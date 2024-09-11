package com.company.Shousi.JUC;


public class ConcurrentDemo {
    private static int index;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    synchronized (lock){
                        index++;
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    synchronized (lock){   //synchronized也被成为对象锁
                        index--;
                    }
                }
            }
        });

        t1.start();
        t2.start();

        //一定要join，否则不等t1,t2运行完，34行就输出
        t1.join();
        t2.join();

        System.out.println(index);
    }
}
