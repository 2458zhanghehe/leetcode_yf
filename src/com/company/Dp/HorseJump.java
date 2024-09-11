package com.company.Dp;

public class HorseJump {
    //从(0,0)开始跳，目标位置(x,y),可跳且必须跳step步
    public static int horseJump1(int x, int y, int step) {

        return process1(0, 0, step, x, y);
    }

    public static int process1(int cx, int cy, int res, int ex, int ey) {
        if (cx < 0 || cx > 9 || cy < 0 || cy > 8) {
            return 0;
        }
        if (res == 0) {
            return (cx == ex) && (cy == ey) ? 1 : 0;
        }
        return process1(cx + 1, cy + 2, res - 1, ex, ey) +
                process1(cx + 2, cy + 1, res - 1, ex, ey) +
                process1(cx + 2, cy - 1, res - 1, ex, ey) +
                process1(cx + 1, cy - 2, res - 1, ex, ey) +
                process1(cx - 1, cy - 2, res - 1, ex, ey) +
                process1(cx - 2, cy - 1, res - 1, ex, ey) +
                process1(cx - 2, cy + 1, res - 1, ex, ey) +
                process1(cx - 1, cy + 2, res - 1, ex, ey);
    }

    //棋盘大小为9行8列
    public static int horseJump2(int x, int y, int step) {
        int[][][] dp = new int[10][9][step + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j][0] = (i == x) && (j == y) ? 1 : 0;
            }
        }
        for (int h = 1; h <= step; h++) {
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
        return dp[0][0][step];
    }

    public static int getvalue(int[][][] dp, int x, int y, int z) {
        if (x < 0 || x > 9 || y < 0 || y > 8) {
            return 0;
        }
        return dp[x][y][z];
    }

    public static void main(String[] args) {
        System.out.println(horseJump1(7, 7, 10));
        System.out.println(horseJump2(7, 7, 10));
    }
}
