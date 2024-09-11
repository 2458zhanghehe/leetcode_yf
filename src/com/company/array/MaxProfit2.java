package com.company.array;
//leetcode 122 买卖股票的最佳时机Ⅱ
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minCost){
                minCost = prices[i];
            }
            if(i == prices.length - 1 || prices[i] > prices[i + 1]){
                ans += prices[i] - minCost;
                minCost = Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}
