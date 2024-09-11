package com.company.Shousi.JUC;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {
    public static void main(String[] args) {
        Account accountCAS = new AccountCAS(10000);
        Account.demo(accountCAS);
    }
}


class AccountCAS implements Account{
    private AtomicInteger balance;

    public AccountCAS(int balance){
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        while(true){
            int prev = balance.get();
            //要修改的余额
            int next = prev - amount;
            //CAS方法具有原子性
            if(balance.compareAndSet(prev,next)){
                break;
            }
        }
    }
}


interface Account{
    public Integer getBalance();
    public void withdraw(Integer amount);

    static void demo(Account account){
        ArrayList<Thread> ts = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            ts.add(new Thread(()->{
                account.withdraw(10);
            }));
        }

        long start = System.nanoTime();
        ts.forEach(Thread::start);
        //让主线程等待其他线程结束 这样才能统计时间  t.join()即当前线程等待t线程结束再继续运行
        ts.forEach(t->{
            try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance() + "   cost:" + (end - start)/1000000 + "ms");
    }
}
