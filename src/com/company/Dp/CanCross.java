package com.company.Dp;

//leetcode 403 青蛙过河
public class CanCross {
    public static boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1){
            return false;
        }
        //青蛙跳的步长从1开始，最多就是每次加1，也就是青蛙最长的一跳可以跳stones.length - 1
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[1][1] = true;
        for (int i = 2; i < stones.length; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int delta = stones[i] - stones[j];
                //青蛙最长能跳stones.length - 1，超过这个距离的两个石头不可能一跳到达
                if(delta > stones.length - 1){
                    continue;
                }
                dp[i][delta] = (delta - 1 >= 0  && dp[j][delta - 1]) ||
                        (delta >= 0 && dp[j][delta]) ||
                        ((delta + 1 >= 0 && delta + 1 <= stones.length - 1) && dp[j][delta + 1]);
            }
        }
        for (int i = 0; i < stones.length; i++) {
            if(dp[stones.length - 1][i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,6,10,13,14};
        boolean can = canCross(stones);
        System.out.println(can);
    }
}
