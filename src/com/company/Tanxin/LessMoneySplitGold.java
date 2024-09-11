package com.company.Tanxin;

import org.omg.CORBA.INTERNAL;

import java.util.PriorityQueue;

public class LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int moneyS = 0;
        while (!pq.isEmpty()) {
            moneyS += pq.poll() + pq.poll();
            pq.add(moneyS);
        }
        return moneyS;
    }
}
