package com.company.Dp;

import java.util.Arrays;

//leetcode 63 不同的路径Ⅱ
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return process(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length);
    }

    private int process(int[][] obstacleGrid, int i, int j, int m, int n) {
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        if(obstacleGrid[i][j] == 1){
            return 0;
        }

        int curAns = 0;
        if(i < m - 1){
            curAns += process(obstacleGrid, i + 1, j, m, n);
        }
        if(j < n - 1){
            curAns += process(obstacleGrid, i, j + 1, m, n);
        }
        return curAns;
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int j = n - 1; j >= 0; j--) {
            if(obstacleGrid[m - 1][j] == 1){
                break;
            }
            dp[j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else if(j == n - 1){
                }else {
                    dp[j] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }

}
