package com.company.Shousi.JUC;

import java.util.concurrent.Semaphore;

//Semaphore限制一个时刻的线程运行数量
public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    //获得运行许可，可被打断
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    //释放许可
                    semaphore.release();
                }
            }).start();
        }
    }
}
