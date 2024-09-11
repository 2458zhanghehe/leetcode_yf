package com.company.practice.sort;

import java.util.PriorityQueue;

public class SortArrayDistanceLessK_p {
    public static void sortArrayDistanceLessK_p(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() == k + 1) {
                arr[i - k - 1] = pq.poll();
                pq.add(arr[i]);
            } else {
                pq.add(arr[i]);
            }
        }
        int i = arr.length - (k + 1);
        while (!pq.isEmpty()) {
            arr[i] = pq.poll();
        }
    }
}
