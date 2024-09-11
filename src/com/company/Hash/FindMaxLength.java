package com.company.Hash;

import java.util.HashMap;

// leetcode 525 连续数组
public class FindMaxLength {
    public static int findMaxLength(int[] nums) {
        //key:前缀和 value：这个前缀和出现的最小下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                nums[i] = -1;
            }
            preSum += nums[i];
            if(preSum == 0){
                ans = Math.max(ans, i + 1);
            }
            if(map.containsKey(preSum)){
                ans = Math.max(ans, i - map.get(preSum) + 1);
            }else {
                map.put(preSum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        findMaxLength(nums);
    }
}
