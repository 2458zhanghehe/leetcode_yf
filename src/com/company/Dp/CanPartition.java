package com.company.Dp;

//leetcode 416 分割等和子集
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int tmp : nums){
            sum += tmp;
        }
        if((sum & 1) != 0){
            return false;
        }
        return process(nums, 0, 0, sum / 2);
    }

    private boolean process(int[] nums, int i, int cur, int aim) {
        if(i == nums.length){
            return cur == aim;
        }
        boolean ans;
        //要
        ans = process(nums, i  + 1, cur + nums[i], aim);
        //不要
        ans = ans || process(nums, i  + 1, cur, aim);

        return ans;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int tmp : nums){
            sum += tmp;
        }
        if((sum & 1) != 0){
            return false;
        }
        int aim = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][aim + 1];


        dp[nums.length][aim] = true;

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = dp[i + 1][j] || (j + nums[i] < aim + 1 && dp[i + 1][j + nums[i]]);
            }
        }
        return dp[0][0];
    }
}
