package com.company.Shousi.JUC;

import java.util.ArrayList;
import java.util.Collections;

public class TestThread {

    public static void main(String[] args) {
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//        t1.setName("窗口1");
//        t2.setName("窗口2");
//        t1.start();
//        t2.start();

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 20, 100, 500);

        ThreadPrize t1 = new ThreadPrize(list);
        ThreadPrize t2 = new ThreadPrize(list);

        t1.setName("抽奖箱1");
        t2.setName("抽奖箱2");
        t1.start();
        t2.start();
    }
}
