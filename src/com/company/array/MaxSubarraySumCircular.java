package com.company.array;

public class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {

        int ans = 0;
        int bigOfSmall0 = Integer.MIN_VALUE;
        boolean allSmall0 = true;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                allSmall0 = false;
                int cur = maxSubArray(nums, i);
                ans = Math.max(ans,cur);

            }
            if(allSmall0){
                bigOfSmall0 = Math.max(bigOfSmall0,nums[i]);
            }
        }
        return allSmall0 ? bigOfSmall0 : ans;
    }

    private static int maxSubArray(int[] nums, int index) {
        int ans = 0;
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(sum == 0 && nums[(i + index) % n] <= 0){
                continue;
            }
            sum += nums[(i + index) % n];
            if(sum < 0){
                sum = 0;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,-3,5};
        int ans = maxSubarraySumCircular(nums);
        System.out.println(ans);
    }
}
