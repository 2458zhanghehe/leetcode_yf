package com.company.Dp;

// lcr 187 破冰游戏  约瑟夫环问题  建议直接看krahets题解的图理解
public class IceBreakingGame {
    public int iceBreakingGame(int num, int target) {
        int[] dp = new int[num + 1];
        for(int i = 2; i <= num; i++){
            dp[i] = (dp[i - 1] + target) % i;
        }
        return dp[num];
    }
}
