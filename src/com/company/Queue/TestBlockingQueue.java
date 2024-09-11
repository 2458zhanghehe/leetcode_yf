package com.company.Queue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestBlockingQueue {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1024*1024);

    public static void main(String[] args) {

        blockingQueue.add(60);
        try {
            //能成功拿到并输出
            Integer take = blockingQueue.take();
            System.out.println(take);
            //此时blockingqueue为空，会一直阻塞等待
            Integer take1 = blockingQueue.take();
            System.out.println(take1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


