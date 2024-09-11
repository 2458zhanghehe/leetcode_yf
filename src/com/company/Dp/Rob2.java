package com.company.Dp;

import java.util.Arrays;

//leetcode 213 打家劫舍Ⅱ
//重要  数组环形问题可以简化为两个数组 (1) [0-len - 2]  [1, len - 1]
public class Rob2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int ans1 = process(Arrays.copyOfRange(nums,0, nums.length - 1));
        int ans2 = process(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(ans1, ans2);
    }

    public int process(int[] nums){
        int len = nums.length;
        int[] dp = new int[len + 2];
        //边界右侧都为0，写n + 1,n + 2都行，n + 1还要处理一个边界
        dp[len] = 0;
        dp[len + 1] = 0;
        for(int i = len - 1; i >= 0; i--){
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }
}
