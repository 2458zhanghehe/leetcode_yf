package com.company.Shousi.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class TestAwaitAndSignal {
    private static final Logger logger = Logger.getLogger(TestAwaitAndSignal.class.getName());


    private static boolean hasCigarette = false;
    private static boolean hasCoffe = false;
    private static ReentrantLock room = new ReentrantLock();
    private static Condition waitCigaretteSet = room.newCondition();
    private static Condition waitCoffeSet = room.newCondition();

    public static void main(String[] args) throws InterruptedException {
        logger.info("测试log");

        new Thread(() -> {
            room.lock();
            try {
                System.out.println("有烟吗" + hasCigarette);
                while (!hasCigarette){
                    System.out.println("没有烟，先休息");
                    try{
                        waitCigaretteSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有烟吗" + hasCigarette);
                if(hasCigarette){
                    System.out.println("小南我开始干活");
                }
            }finally {
                room.unlock();
            }
        }, "小南").start();

        new Thread(() -> {
            room.lock();
            try{
                System.out.println("有咖啡吗" + hasCoffe);
                while (!hasCoffe){
                    System.out.println("没有咖啡，先休息");
                    try {
                        waitCoffeSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有咖啡吗" + hasCoffe);
                if(hasCoffe){
                    System.out.println("小吕我开始干活");
                }
            }finally {
                room.unlock();
            }
        }, "小吕").start();


        for(int i = 0; i < 5 ;i++){
            new Thread(()->{
                room.lock();
                try{
                    System.out.println("其他人拿到锁干活");
                }finally {
                    room.unlock();
                }
            }, "其他人").start();
        }

        Thread.sleep(1000);
        new Thread(()->{
            room.lock();
            try{
                hasCigarette = true;
                waitCigaretteSet.signal();
            }finally {
                room.unlock();
            }
        }, "送烟的").start();
    }
}
