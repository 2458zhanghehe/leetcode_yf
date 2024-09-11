package com.company.GreatFactoryProblem;

import java.util.Arrays;

//leetcode 517 洗衣机
public class PackingMachine {
    public static int packingMachine(int[] arr) {
        int size = arr.length;
        int Sum = Arrays.stream(arr).sum();
        if (Sum % size != 0) {
            return -1;
        }
        int avg = Sum / size;
        int ans = 0;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftRest = leftSum - avg * i;
            int rightRest = (Sum - leftSum - arr[i]) - avg * (size - i - 1);
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, -leftRest - rightRest);
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 5};
        System.out.println(packingMachine(arr));
    }
}
