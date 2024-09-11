package com.company.Shousi.JUC.readWriteLock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.StampedLock;

public class TestStampedLock {
    public static void main(String[] args) throws InterruptedException {
        DataContainerStamped dataContainer = new DataContainerStamped(1);
        new Thread(()->{
            int read = dataContainer.read(1000);
            System.out.println(LocalDateTime.now() + "读到容器data： " + read);
        },"t1").start();
//        Thread.sleep(500);
        new Thread(()->{
            int read = dataContainer.read(1000);
            System.out.println(LocalDateTime.now() + "读到容器data： " + read);
        },"t2").start();
    }
}

class DataContainerStamped{
    private int data;
    //StampedLock不支持重入，不支持条件变量
    private final StampedLock lock = new StampedLock();

    public DataContainerStamped(int data){
        this.data = data;
    }

    //乐观锁升级为读写锁
    public int read(int readTime){
        //乐观读 读读并发
        // 在乐观读时碰到有人要了写锁，则validate()验戳失败，
        // 等到读锁释放后再继续加写锁尝试
        long stamp = lock.tryOptimisticRead();
        try {
            Thread.sleep(readTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(lock.validate(stamp)){
            return data;
        }

        //锁升级，读锁
        try{
            stamp = lock.readLock();
            System.out.println("加读锁");
            try {
                Thread.sleep(readTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return data;
        }finally {
            lock.unlockRead(stamp);
        }
    }

    public void write(int data){
        long stamp = lock.writeLock();
        try{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
        }finally {
            lock.unlockWrite(stamp);
        }
    }

}
