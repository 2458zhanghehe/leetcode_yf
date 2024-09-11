package com.company.Dp;

// LCR 091 粉刷房子
public class MinCost {
    public int minCost1(int[][] costs) {
        return process(0, -1, costs);
    }

    private int process(int index, int pre, int[][] costs) {
        if(index == costs.length){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int color = 0; color < 3; color++) {
            if(color != pre){
                int cur = costs[index][color] + process(index + 1, color, costs);
                ans = Math.min(ans, cur);
            }
        }
        return ans;
    }

    // dp[i][j]为粉刷前i个房子，且最后一个房子颜色为j的最小代价
    //初始时:dp[i] = cost[i]
    //一般表达式: dp[i][j] = cost[i][j] + Min(dp[i - 1][prev])(prev != j)
    public int minCost2(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

}
