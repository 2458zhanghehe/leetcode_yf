package com.company.Shousi.JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
//        //ReentrantLock常用模板
//        lock.lock();
//        try{
//
//        }finally {
//            lock.unlock();
//        }

        lock.lock();

        try{
            System.out.println("main");
            m1();
        }finally {
            lock.unlock();
        }
    }

    public static void m1(){
        lock.lock();
        try{
            System.out.println("重入成功");
        }finally {
            lock.unlock();
        }
    }
}
