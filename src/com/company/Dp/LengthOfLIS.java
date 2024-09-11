package com.company.Dp;


import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import java.util.Arrays;

//Leetcode300 最长递增子序列
public class LengthOfLIS {
    public static int lengthOfLIS1(int[] nums) {
        return process(nums,0,Integer.MIN_VALUE, 0);
    }

    private static int process(int[] nums, int index, int preMax, int alreadyLen){
        if(index >= nums.length){
            return alreadyLen;
        }
        int ans1 = process(nums,index + 1,preMax,alreadyLen);
        int ans2;
        if(nums[index] <= preMax){
            ans2 = alreadyLen;
        }else{
            ans2 = process(nums,index + 1,nums[index],alreadyLen + 1);
        }
        return Math.max(ans1, ans2);
    }

//    public static int lengthOfLIS2(int[] nums){
//        int[][] dp = new int[nums.length + 1][nums.length + 1];
//        for(int i = 0; i < dp[0].length; i++){
//            dp[nums.length][i] = i;
//        }
//        int preMax = Integer.MIN_VALUE;
//    }


    //dp[i]表示以nums[i]结尾的最长递增子序列 Krahets题解
    public static int lengthOfLIS3(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 3, 2, 3};
        int[] nums2 = {10,9,2,5,3,7,101,18};

        int len1 = lengthOfLIS1(nums2);
        System.out.println(len1);

        int len3 = lengthOfLIS3(nums2);
        System.out.println(len3);
    }
}
