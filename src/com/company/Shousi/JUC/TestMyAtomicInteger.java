package com.company.Shousi.JUC;

import java.util.ArrayList;


public class TestMyAtomicInteger {
    public static void main(String[] args) {
        Account accountTest = new AccountTest(10000);
        Account.demo(accountTest);
    }

    static class AccountTest implements Account {
        private MyAtomicInteger balance;

        public AccountTest(int balance){
            this.balance = new MyAtomicInteger(balance);
        }

        @Override
        public Integer getBalance() {
            return balance.get();
        }

        @Override
        public void withdraw(Integer amount) {
            balance.decrement(amount);
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
}
