package com.company.Shousi.JUC.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestSchedulePool {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        long start = System.currentTimeMillis();
        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务一执行  经历" + (System.currentTimeMillis() - start) + "ms后执行");
        },1, TimeUnit.SECONDS);

        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务二执行  经历" + (System.currentTimeMillis() - start) + "ms后执行");
        },1, TimeUnit.SECONDS);

        scheduledThreadPool.schedule(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务三执行  经历" + (System.currentTimeMillis() - start) + "ms后执行");
        },1, TimeUnit.SECONDS);


        Thread.sleep(4000);

        //间隔固定频率执行
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName());
            }
        },2,1,TimeUnit.SECONDS);


        //scheduledThreadPool.shutdown();
    }
}
