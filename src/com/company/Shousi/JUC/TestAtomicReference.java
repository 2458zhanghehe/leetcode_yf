package com.company.Shousi.JUC;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class TestAtomicReference {

    //private AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("abc",0);

    public static void main(String[] args) {

        //BigDecimal传参要使用字符串，否则还是有精度丢失问题
        BigDecimalAccout.demo(new BigDecimalAccountImpl(new BigDecimal("10000")));
    }

}

class BigDecimalAccountImpl implements BigDecimalAccout{

    //保护的是对象，但是对象内属性的修改保护不了
    //想保证属性的原子性可以用Atomic{Reference、Integer}FieldUpdater类
    private AtomicReference<BigDecimal> balance;

    public BigDecimalAccountImpl(BigDecimal bigDecimal){
        balance = new AtomicReference<>(bigDecimal);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true){

            //pre和next是两个对象
            BigDecimal pre = balance.get();
            BigDecimal next = pre.subtract(amount);
            if(balance.compareAndSet(pre, next)){
                break;
            }
        }
    }
}


interface BigDecimalAccout{
    public BigDecimal getBalance();

    public void withdraw(BigDecimal amount);

    public static void demo(BigDecimalAccout bigDecimalAccout){
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            threads.add(new Thread(()->{
                bigDecimalAccout.withdraw(new BigDecimal("10"));
            }));
        }

        long start = System.currentTimeMillis();
        threads.forEach(Thread::start);
        threads.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();

        System.out.println(bigDecimalAccout.getBalance() + "  cost: " + (end - start) + "ms");

    }
}
