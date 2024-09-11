package com.company.practice.Thread;

public class ProducerAndC {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Producer producer1 = new Producer(shop);
        Producer producer2 = new Producer(shop);
        Consumer consumer1 = new Consumer(shop);
        Consumer consumer2 = new Consumer(shop);

        producer1.setName("生产者A");
        producer2.setName("生产者B");
        consumer1.setName("消费者A");
        consumer2.setName("消费者B");

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }
}


class Producer extends Thread{
    private Shop shop;

    public Producer(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            try {
                shop.produce();
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    private Shop shop;

    public Consumer(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            try {
                shop.consume();
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Shop{
    private int nums = 0;

    public synchronized void produce() throws InterruptedException {
        while (nums >= 20){
            wait();
        }
        nums += 1;
        System.out.println(Thread.currentThread().getName() + " 生产了一个商品，库存:" + String.valueOf(nums));
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while (nums == 0){
            wait();
        }
        nums -= 1;
        System.out.println(Thread.currentThread().getName() + " 消费了一个商品，库存:" + String.valueOf(nums));
        notifyAll();
    }
}
