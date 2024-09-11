package com.company.Shousi.JUC;


public class ProducerAndConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Consumer consumer1 = new Consumer(buffer);
       // Consumer consumer2 = new Consumer(buffer);
        producer1.setName("生产者A");
        producer2.setName("生产者B");
        consumer1.setName("消费者A");
        //consumer2.setName("消费者B");
        producer1.start();
        producer2.start();
        consumer1.start();
        //consumer2.start();
    }
}



class Producer extends Thread{
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            try {
                buffer.add();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer extends Thread{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for(int i = 0; i < 20; i++){
            try {
                buffer.pull();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Buffer{
    private Integer nums = 0;

    public synchronized void add() throws InterruptedException {
        while (nums >= 20){
            wait();
        }
        nums += 1;
        String name = Thread.currentThread().getName();
        System.out.println(name + "生产了一个商品，剩余商品数:"+String.valueOf(nums));
        notifyAll();
    }
    public synchronized void pull() throws InterruptedException {
        while (nums == 0){
            wait();
        }
        nums -= 1;
        String name = Thread.currentThread().getName();
        System.out.println(name + "消费了一个商品，剩余商品数:"+String.valueOf(nums));
        notifyAll();
    }
}