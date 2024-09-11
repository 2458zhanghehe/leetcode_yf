package com.company.Shousi.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//在这里，让主线程join每个线程也可以
//但是join是等待线程运行解说，如果是线程池的话，线程不会结束。就不能使用join
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            //lamda表达式中只能使用局部常量，不能使用局部变量，所以加finalI
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown(); //计数减1
            }).start();
        }

        latch.await();  //调用该方法的线程必须等到计数器减为0才能继续运行
        System.out.println("主线程运行");


//        CountDownLatch latch = new CountDownLatch(4);
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 4; i++) {
//            threadPool.submit(()->{
//                try {
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getId());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                latch.countDown(); //计数减1
//            });
//        }
//
//        threadPool.submit(()->{
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("总结");
//        });
//
//        threadPool.shutdown();
    }
}
