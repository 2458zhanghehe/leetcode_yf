package com.company.Shousi.JUC.alternate;

import java.util.concurrent.locks.LockSupport;

public class AlternatePrint4 {

    private static Thread Ta;
    private static Thread Tb;
    private static Thread Tc;

    public static void main(String[] args) {
        ParkUnPark parkUnPark = new ParkUnPark(5);

        Ta = new Thread(() -> {parkUnPark.print(Tb, "a");},"Ta");
        Tb = new Thread(() -> {parkUnPark.print(Tc, "b");},"Tb");
        Tc = new Thread(() -> {parkUnPark.print(Ta, "c");},"Tc");

        Ta.start();
        Tb.start();
        Tc.start();

        LockSupport.unpark(Ta);
    }
}


class ParkUnPark{
    private int loopNumber;

    public ParkUnPark(int loopNumber){
        this.loopNumber = loopNumber;
    }

    public void print(Thread next, String str){
        for(int i = 0; i < loopNumber; i++){
            LockSupport.park();
            System.out.print(str);
            LockSupport.unpark(next);
        }
    }
}
