package com.company.Dp;

public class DeleteChar {
    public int DeleteNums(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j < n + 1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n + 1; j++){
            if(dp[m][j] < ans){
                ans = dp[m][j];
            }
        }
        return ans;
    }
}
