package com.company.Shousi.JUC;

import java.util.ArrayList;
import java.util.Collections;

public class ThreadPrize extends Thread {

    ArrayList<Integer> list;

    public ThreadPrize(ArrayList<Integer> list) {
        this.list = list;
    }


    @Override
    public void run() {
        ArrayList<Integer> box = new ArrayList<>();
        while (true) {
            synchronized (ThreadPrize.class) {
                if (list.size() == 0) {
                    System.out.println(getName() + "共" + box.size() + "项奖，合计：" + box.stream().mapToInt(x -> x).sum());
                    break;
                } else {
                    Collections.shuffle(list);
                    int prize = list.remove(0);
                    box.add(prize);
                    System.out.println(getName() + "产生了" + prize + "元");
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
