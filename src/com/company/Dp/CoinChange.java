package com.company.Dp;


//leetcode322  零钱兑换 最少需要多少个硬币
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        return process(coins,0,amount);
    }

    private static int process(int[] coins, int index, int rest) {
        if(rest < 0){
            return  -1;
        }
        if(rest == 0){
            return 0;
        }
        if(index == coins.length){
            return -1;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= rest/coins[index]; i++){
            int ansI = process(coins, index + 1, rest - i * coins[index]);
            if(ansI != -1){
                ans = Math.min(ans,ansI + i);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int coinChange2(int[] coins, int amount){
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for(int i = 0; i < len + 1; i++){
            dp[i][0] = 0;
        }
        for(int j = 1; j < amount + 1; j++){
            dp[len][j] = -1;
        }

        for(int i = len - 1; i >= 0; i--){
            for(int j = 1; j < amount + 1; j++){
                dp[i][j] = Integer.MAX_VALUE;

                for(int k = 0; k < j/coins[i] + 1; k++){
                    if(dp[i + 1][j - k*coins[i]] != -1){
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j - k * coins[i]] + k);
                    }
                }
                dp[i][j] = dp[i][j] == Integer.MAX_VALUE ? -1 : dp[i][j];
            }
        }
        return dp[0][amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int coinChange = coinChange(coins, 11);
        System.out.println(coinChange);

        int coinChange2 = coinChange2(coins, 11);
        System.out.println(coinChange2);
    }
}
