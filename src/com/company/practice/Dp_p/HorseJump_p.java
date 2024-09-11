package com.company.practice.Dp_p;

import java.util.stream.StreamSupport;

public class HorseJump_p {
    public static int horseJump1(int dx, int dy, int k) {
        return process1(dx, dy, 0, 0, k);
    }

    public static int process1(int dx, int dy, int cx, int cy, int res) {
        if (res == 0) {
            return ((dx == cx) && (dy == cy)) ? 1 : 0;
        }
        if (cx < 0 || cx > 9 || cy < 0 || cy > 8) {
            return 0;
        }
        return process1(dx, dy, cx + 1, cy + 2, res - 1) +
                process1(dx, dy, cx + 2, cy + 1, res - 1) +
                process1(dx, dy, cx + 2, cy - 1, res - 1) +
                process1(dx, dy, cx + 1, cy - 2, res - 1) +
                process1(dx, dy, cx - 1, cy - 2, res - 1) +
                process1(dx, dy, cx - 2, cy - 1, res - 1) +
                process1(dx, dy, cx - 2, cy + 1, res - 1) +
                process1(dx, dy, cx - 1, cy + 2, res - 1);
    }

    public static int horseJump3(int dx, int dy, int k) {
        int[][][] dp = new int[10][9][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j][0] = ((i == dx) && (j == dy)) ? 1 : 0;
            }
        }
        for (int h = 1; h <= k; h++) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    dp[i][j][h] = getvalue(dp, i + 1, j + 2, h - 1) +
                            getvalue(dp, i + 2, j + 1, h - 1) +
                            getvalue(dp, i + 2, j - 1, h - 1) +
                            getvalue(dp, i + 1, j - 2, h - 1) +
                            getvalue(dp, i - 1, j - 2, h - 1) +
                            getvalue(dp, i - 2, j - 1, h - 1) +
                            getvalue(dp, i - 2, j + 1, h - 1) +
                            getvalue(dp, i - 1, j + 2, h - 1);

                }
            }
        }
        return dp[0][0][k];
    }

    public static int getvalue(int[][][] dp, int i, int j, int h) {
        if (i < 0 || i > 9 || j < 0 || j > 8) {
            return 0;
        }
        return dp[i][j][h];
    }

    public static void main(String[] args) {
        System.out.println(horseJump1(7, 7, 10));
        System.out.println(horseJump3(7, 7, 10));
    }
}
