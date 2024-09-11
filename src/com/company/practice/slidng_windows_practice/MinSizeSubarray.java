package com.company.practice.slidng_windows_practice;

public class MinSizeSubarray {
    public static int mss(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        for (int L = 0, R = 0, sum = 0; R < nums.length; R++) {
            sum += nums[R];
            while (sum - nums[L] >= target) {
                sum -= nums[L++];
            }
            if (sum >= target) {
                ans = Math.min(ans, R - L + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
