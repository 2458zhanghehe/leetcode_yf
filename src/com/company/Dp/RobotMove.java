package com.company.Dp;

import java.util.Arrays;

//见笔记77
public class RobotMove {

    //暴力递归
    public static int robotMove1(int N, int start, int end, int k) {  //位置1到n
        return process1(N, end, start, k);
    }

    public static int process1(int N, int end, int cur, int res) {
        if (res == 0) {
            return cur == end ? 1 : 0;
        }
        if (cur == 1) {
            return process1(N, end, 2, res - 1);
        }
        if (cur == N) {
            return process1(N, end, N - 1, res - 1);
        }
        return process1(N, end, cur - 1, res - 1) + process1(N, end, cur + 1, res - 1);
    }

    //加傻缓存构成记忆搜索
    public static int robotMove2(int N, int start, int end, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return process2(N, end, start, k, dp);
    }

    public static int process2(int N, int end, int cur, int res, int[][] dp) {
        if (dp[cur][res] != -1) {
            return dp[cur][res];
        }
        if (res == 0) {
            dp[cur][res] = cur == end ? 1 : 0;
            return dp[cur][res];
        }
        if (cur == 1) {
            dp[cur][res] = process2(N, end, 2, res - 1, dp);
        } else if (cur == N) {
            dp[cur][res] = process2(N, end, N - 1, res - 1, dp);
        } else {
            dp[cur][res] = process2(N, end, cur - 1, res - 1, dp) + process2(N, end, cur + 1, res - 1, dp);
        }
        return dp[cur][res];
    }

    //改为严格表结构
    public static int robotMove3(int N, int start, int end, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 1; i < N + 1; i++) {
            dp[i][0] = i == end ? 1 : 0;
        }
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (j == 1) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else if (j == N) {
                    dp[j][i] = dp[j - 1][i - 1];
                } else {
                    dp[j][i] = dp[j + 1][i - 1] + dp[j - 1][i - 1];
                }
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
