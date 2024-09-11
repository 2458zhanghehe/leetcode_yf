package com.company.Shousi;

public class DeadLockDemo {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();
    //静态方法只能访问静态成员变量

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized(resource1){
                String name = Thread.currentThread().getName();
                System.out.println(name + "获取到资源1");

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(name + "等待资源2");
                synchronized(resource2){
                    System.out.println(name + "获取到资源2");
                }
            }
        },"thread1").start();

        new Thread(() -> {
            synchronized(resource2){
                String name = Thread.currentThread().getName();
                System.out.println(name + "获取到资源2");

                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(name + "等待资源1");
                synchronized(resource1){
                    System.out.println(name + "获取到资源1");
                }
            }
        },"thread2").start();
    }
}
