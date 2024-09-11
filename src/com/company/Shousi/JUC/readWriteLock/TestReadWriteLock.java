package com.company.Shousi.JUC.readWriteLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        DataContainer dataContainer = new DataContainer();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        for(int i = 0; i < 3; i++){
//            //读读共享
////            threadPool.submit(()->{
////                int read = dataContainer.read();
////                System.out.println(Thread.currentThread().getName() + " " + read);
////            });
//
//            //写写互斥
//            threadPool.submit(()->{
//                dataContainer.write(500);
//                System.out.println(Thread.currentThread().getName());
//            });
//        }

        //读写互斥  这里是两个读完才写
        threadPool.submit(()->{
            int read = dataContainer.read();
            System.out.println(Thread.currentThread().getName() + " " + read);
        });
        threadPool.submit(()->{
            int read = dataContainer.read();
            System.out.println(Thread.currentThread().getName() + " " + read);
        });
        Thread.sleep(10);
        threadPool.submit(()->{
            dataContainer.write(500);
            System.out.println(Thread.currentThread().getName());
        });

        threadPool.shutdown();
    }

}

class DataContainer{
    private int money = 10;

    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public int read(){
        r.lock();
        try{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return money;
        }finally {
            r.unlock();
        }
    }

    public void write(int newMoney){
        w.lock();
        try{
           money = newMoney;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            w.unlock();
        }
    }

}
