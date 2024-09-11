package com.company.Bishi.yintai;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){
    }

    public static Singleton get(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(() -> {
            Singleton singleton = Singleton.get();
            System.out.println(singleton);
        });

        threadPool.submit(() -> {
            Singleton singleton = Singleton.get();
            System.out.println(singleton);
        });

        threadPool.submit(() -> {
            Singleton singleton = Singleton.get();
            System.out.println(singleton);
        });

        threadPool.submit(() -> {
            Singleton singleton = Singleton.get();
            System.out.println(singleton);
        });

        threadPool.shutdown();
    }
}
