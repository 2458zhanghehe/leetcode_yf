package com.company.Shousi.JUC.CreateThread;

import org.omg.CORBA.INTERNAL;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                return 100;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t2 = new Thread(futureTask, "t2");

        t2.start();

        System.out.println("主线程在执行");
        System.out.println("主线程在执行");
        //注意，futuretask.get()会阻塞等待返回值
        Integer integer = futureTask.get();
        System.out.println("线程返回值: " + integer);
    }
}
