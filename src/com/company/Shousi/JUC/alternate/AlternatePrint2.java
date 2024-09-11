package com.company.Shousi.JUC.alternate;

//面向对象编写  利用wait & notify实现
public class AlternatePrint2 {
    public static void main(String[] args) {
        WaitNotify_Way alternate = new WaitNotify_Way(5, 'a');

        new Thread(()->{alternate.print('a','b');},"printA").start();
        new Thread(()->{alternate.print('b','c');},"printB").start();
        new Thread(()->{alternate.print('c','a');},"printC").start();

    }
}

class WaitNotify_Way {
    private int loopNumber;
    private char cur;

    public WaitNotify_Way(int loopNumber, char first){
        this.loopNumber = loopNumber;
        this.cur = first;
    }

    public void print(char printChar, char nextChar){
        for (int i = 0; i < loopNumber; i++){
            synchronized (this){
                while (cur != printChar){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(printChar);
                cur = nextChar;
                notifyAll();
            }
        }
    }
}
