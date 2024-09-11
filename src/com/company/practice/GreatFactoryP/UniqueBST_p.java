package com.company.practice.GreatFactoryP;

public class UniqueBST_p {
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
        int[] dp = new int[nums + 1];
        process2(nums, dp);
        return dp[nums];
    }

    public static int process2(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n == 0 || n == 1) {
            dp[n] = 1;
            return dp[n];
        }
        if (n == 2) {
            dp[n] = 2;
            return dp[n];
        }
        for (int i = 0; i < n; i++) {
            dp[n] += process2(i, dp) * process2(n - i - 1, dp);
        }
        return dp[n];
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
        for (int i = 3; i <= nums; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[nums];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(uniqueTree1(i) + "  ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(uniqueTree2(i) + "  ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(uniqueTree3(i) + "  ");
        }
    }
}
