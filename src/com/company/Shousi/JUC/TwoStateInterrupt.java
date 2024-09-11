package com.company.Shousi.JUC;


//两阶段终止模式 优雅的停止一个线程（带料理后事）
public class TwoStateInterrupt {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(100);
        myThread.stop();
    }

    public static class MyThread{
        private Thread t1;

        public void start(){
            t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println("料理后事");
                            break;
                        }
                        try {
                            Thread.sleep(50);
                            System.out.println("+++++++++");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }
            }, "t1");
            t1.start();
        }

        public void stop(){
            t1.interrupt();
        }
    }
}
