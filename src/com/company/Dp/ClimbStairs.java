package com.company.Dp;

//leetcode 70 爬楼梯
public class ClimbStairs {
    public static int climbStairs(int n) {
        return process(n,0);
    }
    private static int process(int n, int index){
        if(index >= n) {
            return index == n ? 1 : 0;
        }
        return process(n,index + 1) + process(n, index + 2);
    }

    public static int climbStairs2(int n){
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < n + 1; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        climbStairs(10);
    }
}
