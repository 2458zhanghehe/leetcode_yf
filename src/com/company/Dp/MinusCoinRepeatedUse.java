package com.company.Dp;

//面额为coins[i]的硬币可以重复使用无数次，返回最少硬币数
//leetcode LCR103
public class MinusCoinRepeatedUse {
    public static int MinusCoin1(int[] coins, int amount) {
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        }
        return process1(coins, 0, amount);
    }

    public static int process1(int[] coins, int index, int res) {
        if (res == 0) {
            return 0;
        }
        if (index == coins.length) {
            return -1;
        }
        int mins = -1;
        for (int i = 0; i <= res / coins[index]; i++) {
            int p = process1(coins, index + 1, res - coins[index] * i);
            if (p != -1) {
                mins = (mins == -1) ? (p + i) : Math.min(p + i, mins);
            }
        }
        return mins;
    }

    public static int MinusCoin3(int[] coins, int amount) {
        if (coins.length == 1) {
            return amount % coins[0] == 0 ? amount / coins[0] : -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[coins.length][i] = -1;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - coins[i] < 0) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    if (dp[i][j - coins[i]] == -1 && dp[i + 1][j] == -1) {
                        dp[i][j] = -1;
                    } else if (dp[i][j - coins[i]] != -1 && dp[i + 1][j] != -1) {
                        dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i + 1][j]);
                    } else {
                        dp[i][j] = dp[i][j - coins[i]] == -1 ? dp[i + 1][j] : dp[i][j - coins[i]] + 1;
                    }
                }
            }
        }
        return dp[0][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5, 10};
        int target = 10;
        System.out.println(MinusCoin1(coins, target));
        System.out.println(MinusCoin3(coins, target));
    }
}
