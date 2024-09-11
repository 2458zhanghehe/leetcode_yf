package com.company.Dp;

public class UniqueBST {
    public static int uniqueTree1(int nums) {
        return process1(nums);
    }

    public static int process1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += process1(i) * process1(n - i - 1);
        }
        return res;
    }

    public static int uniqueTree2(int nums) {
        int[] map = new int[nums + 1];
        return process2(nums, map);
    }

    public static int process2(int n, int[] map) {
        if (map[n] != 0) {
            return map[n];
        }
        if (n == 0 || n == 1) {
            map[n] = 1;
            return map[n];
        }
        if (n == 2) {
            map[n] = 2;
            return map[n];
        }
        for (int i = 0; i < n; i++) {
            map[n] += process2(i, map) * process2(n - i - 1, map);
        }
        return map[n];
    }

    public static int uniqueTree3(int nums) {
        int[] dp = new int[nums + 1];
        dp[0] = 1;
        if (nums >= 1) {
            dp[1] = 1;
        }
        if (nums >= 2) {
            dp[2] = 2;
        }
        for (int n = 3; n <= nums; n++) {
            for (int i = 0; i < n; i++) {
                dp[n] += dp[i] * dp[n - i - 1];
            }
        }
        return dp[nums];
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(uniqueTree1(i));
            if (uniqueTree1(i) != uniqueTree2(i)) {
                System.out.println("error!");
                break;
            }
            if (uniqueTree1(i) != uniqueTree3(i)) {
                System.out.println("error!");
                break;
            }
        }
    }
}
