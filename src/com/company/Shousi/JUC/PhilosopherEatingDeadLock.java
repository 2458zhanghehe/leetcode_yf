package com.company.Shousi.JUC;


//哲学家就餐问题
//5个哲学家坐在圆桌上，一共有5根筷子，两个哲学家之间有一根筷子
public class PhilosopherEatingDeadLock {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");

        new Philosopher("苏格拉底", c1, c2).start();
        new Philosopher("柏拉图", c2, c3).start();
        new Philosopher("亚里士多德", c3, c4).start();
        new Philosopher("阿基米德", c4, c5).start();
        new Philosopher("赫拉克利特", c5, c1).start();
    }
}


class Philosopher extends Thread{
    private String name;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right){
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while(true){
            synchronized (left){
                synchronized (right){
                    eat();
                }
            }
        }
    }

    private void eat(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "正在吃饭");
    }
}

class Chopstick{
    private String name;
    public Chopstick(String name){
        this.name = name;
    }
}
