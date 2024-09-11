package com.company.Shousi.JUC;

import java.util.concurrent.locks.LockSupport;

//park unpark实现
public class ShunXuPrint21_2 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("1");
        }, "t1");
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("2");
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();
    }

}
