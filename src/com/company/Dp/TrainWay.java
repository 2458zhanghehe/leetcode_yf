package com.company.Dp;

// LCR 127 跳跃训练
public class TrainWay {
    public static int trainWays(int num) {
        if(num == 0){
            return 1;
        }
        int[] dp = new int[num + 1];
        dp[num] = 1;
        dp[num - 1] = 1;
        for (int i = num - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
            //本题不能使用long数组，最后取余，当n = 92+时，long都装不下
            dp[i] = dp[i] % 1000000007;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        trainWays(92);
    }
}
