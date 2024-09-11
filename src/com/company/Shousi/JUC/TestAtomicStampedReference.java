package com.company.Shousi.JUC;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.atomic.*;

public class TestAtomicStampedReference {
    public static void main(String[] args) {
        BigDecimalAccout1.demo(new BigDecimalAccount1Impl(new BigDecimal("10000")));
    }
}

class BigDecimalAccount1Impl implements BigDecimalAccout1{

    private AtomicStampedReference<BigDecimal> balance;

    public BigDecimalAccount1Impl(BigDecimal bigDecimal){
        balance = new AtomicStampedReference<>(bigDecimal, 0);
    }

    @Override
    public BigDecimal getBalance() {
        return balance.getReference();
    }

    @Override
    public void withdraw(BigDecimal amount) {
        while (true){
            BigDecimal pre = balance.getReference();
            int stamp = balance.getStamp();
            BigDecimal next = pre.subtract(amount);
            if(balance.compareAndSet(pre, next,stamp, stamp + 1)){
                break;
            }
        }
    }
}


interface BigDecimalAccout1{
    public BigDecimal getBalance();

    public void withdraw(BigDecimal amount);

    public static void demo(BigDecimalAccout1 bigDecimalAccout1){
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 1000; i++){
            threads.add(new Thread(()->{
                bigDecimalAccout1.withdraw(new BigDecimal("10"));
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

        System.out.println(bigDecimalAccout1.getBalance() + "  cost: " + (end - start) + "ms");
    }
}
