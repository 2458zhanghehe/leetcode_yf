package com.company.array;

import java.util.HashMap;

//leetcode 560 和为K的子数组
public class SubArraySumK {
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        for (int left = 0; left < len; left++) {
            int curSum = 0;
            for (int right = left; right < len; right++) {
                curSum += nums[right];
                if(curSum == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    //前缀和优化
    public static int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];

        for (int i = 0; i < len; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        int ans = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                if(preSum[right + 1] - preSum[left] == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    //前缀和加哈希表优化
    public static int subarraySum3(int[] nums, int k) {
        int len = nums.length;
        int ans = 0;
        //key:前缀和  num:个数
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0,1);
        int preSum = 0;
        for (int i = 0; i < len; i++) {
            preSum += nums[i];
            //只关心在此之前有多少个
            Integer count = countMap.getOrDefault(preSum - k, 0);
            ans += count;
            countMap.put(preSum, countMap.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1 ,1};
        int ans = subarraySum(nums, 2);
        System.out.println(ans);
    }
}
