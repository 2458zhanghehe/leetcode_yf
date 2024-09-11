package com.company.practice.Dp_p;

import java.util.Arrays;

public class RobotMove_p {
    public static int robotMove1(int N, int start, int des, int k) {
        return process1(N, des, start, k);
    }

    public static int process1(int N, int des, int cur, int res) {
        if (res == 0) {
            return cur == des ? 1 : 0;
        }
        if (cur < 0 || cur > N) {
            return 0;
        }
        return process1(N, des, cur - 1, res - 1) + process1(N, des, cur + 1, res - 1);
    }

    public static int robotMove2(int N, int start, int des, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process2(N, des, start, k, dp);
    }

    public static int process2(int N, int des, int cur, int res, int[][] dp) {
        if (cur < 1 || cur > N) {
            return 0;
        }
        if (dp[cur][res] != -1) {
            return dp[cur][res];
        }
        if (res == 0) {
            dp[cur][res] = cur == des ? 1 : 0;
            return dp[cur][res];
        }
        dp[cur][res] = process2(N, des, cur - 1, res - 1, dp) + process2(N, des, cur + 1, res - 1, dp);
        return dp[cur][res];
    }

    public static int robotMove3(int N, int start, int des, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i == des ? 1 : 0;
        }
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 1; i < dp.length; i++) {
                dp[i][j] = dp[i - 1][j - 1] + (i + 1 < dp.length ? dp[i + 1][j - 1] : 0);
            }
        }
        return dp[2][4];
    }

    public static void main(String[] args) {
        System.out.println(robotMove1(5, 2, 4, 4));
        System.out.println(robotMove2(5, 2, 4, 4));
        System.out.println(robotMove3(5, 2, 4, 4));
    }
}
