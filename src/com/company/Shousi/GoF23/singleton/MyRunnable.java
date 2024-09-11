package com.company.Shousi.GoF23.singleton;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        LazyMan instance = LazyMan.getInstance();
        System.out.println(instance);
    }


}
