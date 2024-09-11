package com.company.Shousi.JUC;

public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("running");
            }
        });

        t1.setDaemon(true);
        t1.start();
        //main线程并非守护线程
        Thread.sleep(4000);
    }
}
