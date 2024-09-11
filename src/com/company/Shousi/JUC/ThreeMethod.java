package com.company.Shousi.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreeMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread1 thread1 = new Thread1();
//        Thread1 thread2 = new Thread1();
//        thread1.setName("线程1");
//        thread2.setName("线程2");
//        thread1.start();
//        thread2.start();


//        MyRunnableImpl runnable1 = new MyRunnableImpl();
//        MyRunnableImpl runnable2 = new MyRunnableImpl();
//        Thread thread3 = new Thread(runnable1);
//        Thread thread4 = new Thread(runnable2);
//        thread3.setName("线程3");
//        thread4.setName("线程4");
//        thread3.start();
//        thread4.start();


        MyCallableImpl myCallable1 = new MyCallableImpl();
        MyCallableImpl myCallable2 = new MyCallableImpl();
        FutureTask<Integer> task1 = new FutureTask<>(myCallable1);
        FutureTask<Integer> task2 = new FutureTask<>(myCallable2);
        Thread thread5 = new Thread(task1);
        Thread thread6 = new Thread(task2);
        thread5.setName("线程5");
        thread6.setName("线程6");
        thread5.start();
        thread6.start();

        Integer integer1 = task1.get();
        System.out.println("线程5返回值：" + String.valueOf(integer1));
        Integer integer2 = task2.get();
        System.out.println("线程6返回值：" + String.valueOf(integer2));

    }
}


class Thread1 extends Thread{
    private int i = 0;
    @Override
    public void run() {
        for(; i <= 20; i++){
            System.out.println(Thread.currentThread().getName() + " is counting:" + String.valueOf(i));
        }
    }
}

class MyRunnableImpl implements Runnable{
    private int i = 0;
    @Override
    public void run() {
        for(; i <= 20; i++){
            System.out.println(Thread.currentThread().getName() + " is counting:" + String.valueOf(i));
        }
    }
}

class MyCallableImpl implements Callable{
    private int i = 0;

    @Override
    public Object call() throws Exception {
        for(; i <= 20; i++){
            System.out.println(Thread.currentThread().getName() + " is counting:" + String.valueOf(i));
        }
        return i;
    }
}