package com.company.Shousi.JUC;

public class TestSy {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        new Thread(()->{
            lock.get1();
        }).start();

        Thread.sleep(2000);
        new Thread(()->{
            lock.get1();
        }).start();

        new Thread(()->{
            lock.get2();
        }).start();
    }
}


class Lock{
    public synchronized void get1(){
        System.out.println("成功进入get1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void get2(){
        System.out.println("成功进入get2");
    }
}
