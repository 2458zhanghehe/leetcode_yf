package com.company.slidingW;

//leetcode 713 乘积小于K的子数组
public class ＮumSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int mul = 1;
        int ans = 0;

        while(r < nums.length){
            mul *= nums[r];
            while(mul >= k){
                mul /= nums[l++];
            }
            //每次r往右移动，应该加上 r - l + 1 种数据组合
            // nums[r]
            // nums[r - 1], nums[r]
            // nums[r - 2]. nums[r - 1], nums[r]
            // ...
            // nums[l] ... nums[r]
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
