package com.company.Shousi.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class TestInterruptAwait {
    private static final Logger logger = Logger.getLogger(TestInterruptAwait.class.getName());
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                logger.info("线程1开始等待");
                condition.await();
                logger.info("线程1继续执行");
            } catch (InterruptedException e) {
                logger.info("线程1被打断");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");

        t1.start();
        Thread.sleep(4000);
        logger.info("此时打断线程1");
        t1.interrupt();
        Thread.sleep(4000);
        lock.lock();
        try {
            logger.info("主线程开始唤醒");
            condition.signal();
            logger.info("主线程唤醒结束");
        } finally {
            lock.unlock();
        }
    }
}
