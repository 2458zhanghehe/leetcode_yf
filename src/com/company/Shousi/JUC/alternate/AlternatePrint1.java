package com.company.Shousi.JUC.alternate;

//面向过程 编写
public class AlternatePrint1 {

    private static Object lock = new Object();
    private static char cur = 'a';

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                synchronized (lock){
                    while (cur != 'a'){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("a");
                    cur = 'b';
                    lock.notifyAll();
                }
            }
        },"a");

        Thread b = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                synchronized (lock){
                    while (cur != 'b'){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("b");
                    cur = 'c';
                    lock.notifyAll();
                }
            }
        },"b");

        Thread c = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                synchronized (lock){
                    while (cur != 'c'){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("c");
                    cur = 'a';
                    lock.notifyAll();
                }
            }
        },"c");

        a.start();
        b.start();
        c.start();
    }
}


