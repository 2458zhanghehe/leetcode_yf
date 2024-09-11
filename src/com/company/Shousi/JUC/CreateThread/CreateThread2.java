package com.company.Shousi.JUC.CreateThread;

public class CreateThread2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("利用runnable创建线程");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable,"t1");
        thread.start();
    }
}
