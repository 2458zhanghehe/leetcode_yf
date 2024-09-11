package com.company.array;

// leetcode 674 最长连续递增序列
public class FindLengthOfLCIS {
    public static int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                count++;
                ans = Math.max(ans, count);
            }else {
                count = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        findLengthOfLCIS(nums);
    }
}
