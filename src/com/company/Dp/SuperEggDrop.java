package com.company.Dp;

// leetcode 887 鸡蛋掉落
// dp[i][j]: i个鸡蛋，扔j次，可以确定的楼层数量
// dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
// 在第x层扔，则x层确定 + （如果x层破了，即dp[i - 1][j - 1]在楼下实验，
// 如果没破，即dp[i][j - 1]在楼上实验，等价于dp[i][j - 1]在楼下实验）
public class SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        //初始dp[0][j]都为0;

        for(int j = 1; j < n + 1; j++){
            for (int i = 1; i < k + 1; i++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
            }
            if(dp[k][j] >= n){
                return dp[k][j];
            }
        }
        return -1;
    }
}
