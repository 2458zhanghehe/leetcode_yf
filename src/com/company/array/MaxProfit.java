package com.company.array;

//leetcode 121 买卖股票的最佳时机
public class MaxProfit {

    //过部分
    public static int maxProfit(int[] prices) {
        int l = 0;
        int r = prices.length - 1;
        int minIndex = l;
        int maxIndex = r;

        while(r > minIndex && l < maxIndex){
            if(r < l && prices[minIndex] > prices[l] && prices[maxIndex] < prices[r]){
                if(prices[minIndex] - prices[l] > prices[r] - prices[maxIndex]){
                    minIndex = l;
                }else {
                    maxIndex = r;
                }
            }else {
                if(prices[minIndex] > prices[l]){
                    minIndex = l;
                }
                if(prices[maxIndex] < prices[r]){
                    maxIndex = r;
                }
            }
            l++;
            r--;
        }

        while(r > minIndex){
            if(prices[maxIndex] < prices[r]){
                maxIndex = r;
            }
            r--;
        }

        while(l < maxIndex){
            if(prices[minIndex] > prices[l]){
                minIndex = l;
            }
            l++;
        }

        return prices[maxIndex] > prices[minIndex] ? prices[maxIndex] - prices[minIndex] : 0;
    }

    //超时
    public static int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                if(sell - buy > ans){
                    ans = sell - buy;
                }
            }
        }
        return ans;
    }

    public static int maxProfit3(int[] prices) {
        int ans = 0;

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minCost){
                minCost = prices[i];
            }
            ans = Math.max(ans, prices[i] - minCost);
        }
        return ans;
    }





    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 1, 0, 0, 1};
        int ans1 = maxProfit(nums);
        System.out.println(ans1);

        int ans2 = maxProfit2(nums);
        System.out.println(ans2);
    }
}
