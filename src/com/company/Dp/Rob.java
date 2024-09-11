package com.company.Dp;

//leetcode 198 打家劫舍
public class Rob {
    public static int rob(int[] nums) {
        return process(nums,0);
    }
    private static int process(int[] nums, int i) {
        if(i >= nums.length){
            return 0;
        }
        return Math.max(nums[i] + process(nums, i + 2), process(nums, i + 1));
    }

    public int rob2(int[] nums){
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

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 9, 3, 1};
        int money = rob(arr);
        System.out.println(money);
    }
}
