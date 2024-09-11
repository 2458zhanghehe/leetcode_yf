package com.company.practice.GreatFactoryP;

import java.util.Arrays;

//leetcode 517 洗衣机
public class PackingMachine_p {
    public static int packingMachine(int[] machines) {
        int Sum = Arrays.stream(machines).sum();
        int N = machines.length;
        if (Sum % N != 0) {
            return -1;
        }
        int avg = Sum / N;
        int leftSum = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int leftRes = leftSum - (i * avg);
            int rightRes = (Sum - leftSum - machines[i]) - (N - i - 1) * avg;
            if (leftRes < 0 && rightRes < 0) {
                ans = Math.max(ans, -leftRes - rightRes);
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRes), Math.abs(rightRes)));
            }
            leftSum += machines[i];
        }
        return ans;
    }
}
