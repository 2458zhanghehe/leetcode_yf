package com.company.Dp;

//leetcode70
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
        int[] dp = new int[n + 2];
        //这里n + 2是因为题目虽然给的n层楼梯，但起始位置0没有算上，所以其实题目空间为n + 1
        dp[n] = 1;
        dp[n+1] = 0;
        for(int i = n - 1; i >= 0; i--){
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        climbStairs(10);
    }
}
