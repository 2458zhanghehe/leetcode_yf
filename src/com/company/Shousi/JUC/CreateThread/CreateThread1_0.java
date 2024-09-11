package com.company.Shousi.JUC.CreateThread;

public class CreateThread1_0 extends Thread {

    static Integer ticket = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (CreateThread1_0.class) {
                if (ticket == 1000) {
                    break;
                } else {
                    try {
                        sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + "卖出了" + ticket + "票");

                }
            }

        }
    }
}
