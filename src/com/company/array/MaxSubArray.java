package com.company.array;

//leetcode 53 最大子数组和
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int ans = 0;
        int sum = 0;
        int bigOfSmall0 = Integer.MIN_VALUE;
        boolean allSmall0 = true;
        for(int i = 0; i < nums.length; i++){
            if(sum == 0 && nums[i] <= 0){
                bigOfSmall0 = Math.max(bigOfSmall0,nums[i]);
                continue;
            }
            allSmall0 = false;
            sum += nums[i];
            if(sum < 0){
                sum = 0;
            }
            ans = Math.max(ans,sum);
        }
        return allSmall0 ? bigOfSmall0 : ans;
    }
}
