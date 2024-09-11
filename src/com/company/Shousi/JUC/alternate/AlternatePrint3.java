package com.company.Shousi.JUC.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//面向对象编写  利用await & signal实现
public class AlternatePrint3 {
    public static void main(String[] args) {
        AwaitSignal_way awaitSignal = new AwaitSignal_way(5, 'a');
        Condition AwaitSet = awaitSignal.newCondition();
        Condition BwaitSet = awaitSignal.newCondition();
        Condition CwaitSet = awaitSignal.newCondition();

        new Thread(()->{awaitSignal.print('a','b',AwaitSet,BwaitSet);},"printA").start();
        new Thread(()->{awaitSignal.print('b','c',BwaitSet,CwaitSet);},"printB").start();
        new Thread(()->{awaitSignal.print('c','a',CwaitSet,AwaitSet);},"printC").start();

    }
}

//直接继承ReentrantLock
class AwaitSignal_way extends ReentrantLock {
    private int loopNumber;
    private char cur;

    public AwaitSignal_way(int loopNumber, char first){
        this.loopNumber = loopNumber;
        this.cur = first;
    }

    public void print(char printChar, char nextChar, Condition curWaitSet, Condition signalWaitSet){
        for (int i = 0; i < loopNumber; i++){
            lock();
            try{
                //这里利用ReentrantLock的多条件特点（多休息室），不存在虚假唤醒问题，所以直接用if就行
                if (cur != printChar){
                    try {
                        curWaitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(printChar);
                cur = nextChar;
                signalWaitSet.signal();
            }finally {
                unlock();
            }
        }
    }
}
