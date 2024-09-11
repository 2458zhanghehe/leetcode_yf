package com.company.Shousi.JUC.CreateThread;

public class CreateThread1_1 {
    public static void main(String[] args) {
        //new A(){} 是匿名内部类的意思。表示创建了一个匿名类，这类继承或者实现了A！
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("线程");
            }
        };
        thread.start();
    }
}
