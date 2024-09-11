package com.company.linklist;


// leetcode 264 丑数2
public class NthUglyNumber {
    //题解
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[c] * 5, Math.min(dp[a] * 2, dp[b] * 3));
            if(dp[i] == dp[a] * 2){
                a++;
            }
            if(dp[i] == dp[b] * 3){
                b++;
            }
            if(dp[i] == dp[c] * 5){
                c++;
            }
        }
        return dp[n - 1];
    }
}
