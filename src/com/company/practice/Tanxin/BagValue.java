package com.company.practice.Tanxin;

import java.util.PriorityQueue;

public class BagValue {
    public static int BG(int[] weights, int[] values, int bag) {
        return process(0, bag, weights, values);
    }

    public static int process(int i, int resbag, int[] weights, int[] values) {
        if (i == weights.length || resbag == 0) {
            return 0;
        }
        return Math.max(process(i + 1, resbag, weights, values),
                weights[i] > resbag ? 0 : process(i + 1, resbag - weights[i], weights, values) + values[i]);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{3, 5, 9, 2};
        int[] values = new int[]{2, 4, 10, 3};
        int bag = 10;
        System.out.println(BG(weights, values, bag));
    }
}
