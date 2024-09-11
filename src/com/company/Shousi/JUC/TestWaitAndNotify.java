package com.company.Shousi.JUC;

public class TestWaitAndNotify {

    private static final Object lock = new Object();
    private static boolean hasCigarette = false;
    private static boolean hasCoffe = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lock){
                System.out.println("有烟吗" + hasCigarette);
                while (!hasCigarette){
                    System.out.println("没有烟，先休息");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有烟吗" + hasCigarette);
                if(hasCigarette){
                    System.out.println("小南我开始干活");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (lock){
                System.out.println("有咖啡吗" + hasCoffe);
                while (!hasCoffe){
                    System.out.println("没有咖啡，先休息");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有咖啡吗" + hasCoffe);
                if(hasCoffe){
                    System.out.println("小吕我开始干活");
                }
            }
        }, "小吕").start();


        for(int i = 0; i < 5 ;i++){
            new Thread(()->{
                synchronized (lock){
                    System.out.println("其他人拿到锁干活");
                }
            }, "其他人").start();
        }

        Thread.sleep(1000);
        new Thread(()->{
            synchronized (lock){
                hasCigarette = true;
                System.out.println("烟到了");
                /*注意仅调用notify()会随机唤醒，容易唤醒不相干线程
                * 最佳实践：notifyAll()  各个线程使用循环
                * while(条件不满足){
                *   lock.wait()
                * }
                * 另外，注意调用wait和notify方法，都必须先获取锁，在锁中调用
                * */
                lock.notifyAll();
            }
        }, "送烟的").start();
    }
}
