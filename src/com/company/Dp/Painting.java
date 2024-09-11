package com.company.Dp;

//有效涂色问题
public class Painting {
    public int wayNum(int n, int m){
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i < n + 1; i++){
            dp[i][1] = m;
        }
        for(int j = 2; j < m + 1; j++){
            dp[1][j] = 0;
        }

        for(int i = 2; i < n + 1; i++){
            for(int j = 2; j < m + 1; j++){
                if(j > i){
                    dp[i][j] = 0;
                }
                dp[i][j] = dp[i - 1][j] * j + dp[i - 1][j - 1] * (m - j + 1);
            }
        }
        return dp[n][m];
    }
}
