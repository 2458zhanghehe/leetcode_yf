package com.company.Dp;

//leetcode 152 乘积最大的子数组
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && ans < 0){
                ans = 0;
            } else if (nums[i] < 0) {
                int j = i;
                while(j + 1 < nums.length && nums[j + 1] < 0){
                    j++;
                }
                if(j - i < 1){
                    ans = Math.max(ans, nums[i]);
                }else {
                    int cur = 1;
                    for (int k = i; k <= j && k + 1 <= j; k+=2) {
                        cur *= nums[k] * nums[k + 1];
                    }
                    ans = Math.max(ans, cur);
                    cur = 1;
                    for (int k = i + 1; k <= j && k + 1 <= j; k+=2) {
                        cur *= nums[k] * nums[k + 1];
                    }
                    ans = Math.max(ans, cur);
                }
                i = j;
            } else {
                int cur = nums[i];
                while(i + 1 < nums.length && nums[i + 1] > 0){
                    cur *= nums[++i];
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public static int maxProduct2(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];

        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, -1};
        System.out.println(maxProduct(nums));
    }
}
