package com.company.Dp;

//leetcode 279 完全平方数
// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量。

public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = i;
            for(int j = 1; i - j*j >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n){
        return process(1, n);
    }

    private int process(int index, int n) {
        if(n == 0){
            return 0;
        }

        if(index * index > n){
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i * index * index <= n; i++) {
            int cur = process(index + 1, n - i * index * index);
            if(cur != -1){
                res = Math.min(res, cur + i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int numSquares3(int n){
        int sqrt = (int) Math.sqrt(n);
        int[][] dp = new int[sqrt + 1][n + 1];
        for(int i = 0; i <= sqrt; i++){
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            dp[sqrt][i] = sqrt * sqrt == i ? 1 : -1;
        }

        for (int i = sqrt - 1; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k * i * i <= j; k++) {
                    int cur = dp[i+1][j - k * i * i];
                    if(cur != -1){
                        dp[i][j] = Math.min(dp[i][j], cur + k);
                    }
                }
                dp[i][j] = dp[i][j] == Integer.MAX_VALUE ? -1 : dp[i][j];
            }
        }
        return dp[1][n];
    }


    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
        System.out.println(numSquares.numSquares2(12));
        System.out.println(numSquares.numSquares3(12));
    }

}
