package com.company.Shousi.JUC;

//活锁：两个线程并没有发生阻塞，但谁也结束不了
public class TestliveLock {
    public static volatile int count = 20;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (count > 0) {
                count--;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(() -> {
            while (count < 40) {
                count++;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
