package com.company.practice.GreatFactoryP;

import java.util.Arrays;

public class PCAndButteryMostLongTime {
    public static long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long[] sum = new long[batteries.length];
        sum[0] = batteries[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + batteries[i];
        }
        long L = 0;
        long R = sum[sum.length - 1] / n;
        long midTime = 0;
        long maxTime = 0;
        while (L <= R) {
            midTime = (L + R) / 2;
            if (isOk(batteries, sum, n, midTime)) {
                maxTime = midTime;
                L = midTime + 1;
            } else {
                R = midTime - 1;
            }
        }
        return maxTime;
    }

    public static boolean isOk(int[] batteries, long[] sum, int n, long midTime) {
        int left = -1;
        int L = 0;
        int R = batteries.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = (L + R) / 2;
            if (batteries[mid] >= midTime) {
                left = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        n -= left >= 0 ? batteries.length - left : 0;
        long res = left < 0 ? sum[sum.length - 1] : (left == 0 ? 0 : sum[left - 1]);
        return res >= midTime * (long) n;
    }

    public static class Node {
        public int val;
        public Node next;

        public Node(int v) {
            val = v;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = null;
        if (head.next.next == null) {
            System.out.println("1");
        }
    }

}
