package com.company.Shousi.JUC;

import java.util.concurrent.locks.LockSupport;

public class TestParkUnpark {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running");
                LockSupport.park();
            }
        }, "t1");

        //park unpark只有在线程启动后调用才生效
        //另外，提前连续调用多次unpark，counter都为1，只能应对一次park 可以理解为park将counter置为1，unpark置为0
        t1.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t1);


    }
}
