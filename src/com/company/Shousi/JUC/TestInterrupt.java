package com.company.Shousi.JUC;


public class TestInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("++++++++");
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }
            }
        }, "t1");

        t1.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();

        /*注意：打断只是把打断标记记为true，并不会真的停止打断的线程，还需要自己加判断if（interrupt）break
        * 另外，如果打断时线程正处于wait、sleep、join状态，（即阻塞状态），标记为会被还原为false，并触发异常，
        * 需要在catch中重新置标志位为true*/
    }
}
