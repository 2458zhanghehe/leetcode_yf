package com.company.Dp;

public class CoinWays {
    //零钱兑换问题方法数 arr中没有重复数，但arr[i]可以重复使用
    public static int coinWays1(int[] arr, int target) {
        return process1(arr, 0, target);
    }

    public static int process1(int[] arr, int index, int res) {
        if (res == 0) {
            return 1;
        }
        if (res < 0 || index == arr.length) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < res / arr[index] + 1; i++) {
            sum += process1(arr, index + 1, res - arr[index] * i);
        }
        return sum;
    }

    public static int coinWays3(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                for (int k = 0; k < j / arr[i] + 2; k++) {
                    dp[i][j] += (j - arr[i] * k) < 0 ? 0 : dp[i + 1][j - arr[i] * k];
                }
            }
        }
        return dp[0][target];
    }

    public static int coinWays4(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i + 1][j] + (j - arr[i] < 0 ? 0 : dp[i][j - arr[i]]);
            }   //进一步优化,第三个for循环有重复计算，dp[i+1][j]左侧的所有值之和就等于dp[i][j-arr[i]]
        }
        return dp[0][target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 10};
        System.out.println(coinWays1(arr, 10));
        System.out.println(coinWays3(arr, 10));
        System.out.println(coinWays4(arr, 10));
    }
}
