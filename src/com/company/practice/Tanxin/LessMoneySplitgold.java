package com.company.practice.Tanxin;

import java.util.PriorityQueue;

public class LessMoneySplitgold {
    public static int LMSG(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int sum = 0;
        int cur_sum = 0;
        while (!pq.isEmpty()) {
            cur_sum = pq.poll() + pq.poll();
            pq.add(cur_sum);
            sum += cur_sum;
        }
        return sum;
    }
}
