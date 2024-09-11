package com.company.Dp;

// LCR 166 珠宝的最高价值
public class JewelleryValue {
    public int jewelleryValue(int[][] frame) {
        int h = frame.length;
        int w = frame[0].length;
        int[][] dp = new int[h + 1][w];
        for (int i = 1; i <= h; i++) {
            dp[i][0] = dp[i - 1][0] + frame[i - 1][0];
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + frame[i - 1][j];
            }
        }
        return dp[h][w - 1];
    }
}
