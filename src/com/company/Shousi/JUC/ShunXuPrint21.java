package com.company.Shousi.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//线程t1打印1，线程t2打印2  要求打印出21（2先打印）
public class ShunXuPrint21 {

    private static boolean is2Printed = false;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Condition waitSet = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try{
                while(!is2Printed){
                    try{
                        waitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1");
            }finally {
                lock.unlock();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try{
                System.out.println("2");
                is2Printed = true;
                //重要重要  reentrantLock是signal()方法，不要调用notify
                waitSet.signal();
            }finally {
                lock.unlock();
            }
        }, "t2");


        t1.start();
        Thread.sleep(10);
        t2.start();

    }
}
