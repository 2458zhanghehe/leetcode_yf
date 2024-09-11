package com.company.Shousi.GoF23.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//懒汉式单例模式
public class LazyMan {

    private LazyMan(){
        //System.out.println(Thread.currentThread().getId());
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式的懒汉式单例， DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();
                    /*
                    * new不是原子性操作
                    * 包含3步：
                    * 1.分配内存空间
                    * 2.执行构造方法，初始化对象
                    * 3.把这个对象指向这个空间
                    *
                    * 有可能会发生指令重排，比如线程1拿到锁执行132，当执行完3尚未执行2时
                    * 线程2通过第一个if判断，直接返回，就返回了一个空对象，如果这个对象初
                    * 始化比较复杂，可能另一个线程拿到空对象已经开始使用了，2还未执行，这时就发生了问题。
                    *通过在lazyMan上添加volatile关键字防止指令重排
                    * */

                    //另外，synchronized不能禁止指令重排，但是synchronized可以保证有序性，
                    // 前提是这个变量完全在synchronized代码块中没有发生逃逸。
                }
            }
        }

        return lazyMan;
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(new MyRunnable());
        executorService.submit(()->{
            LazyMan.getInstance();
        });

        executorService.shutdown();


        for(int i = 0; i < 10; i++){
            new Thread(() -> {
                LazyMan instance = LazyMan.getInstance();
            }).start();
        }

    }
}
