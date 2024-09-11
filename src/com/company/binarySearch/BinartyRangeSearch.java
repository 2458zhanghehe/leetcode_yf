package com.company.binarySearch;

import java.util.Arrays;

 // leetcode 34 在排序数组中查找元素的第一个和最后一个位置
public class BinartyRangeSearch {
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = n - 1;


        //返回大于等于target的最左边界，注意有可能返回nums.length
        while(l <= r){
            int mid = l + ((r - l) >> 1);
            if(nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }


        if(l < n && nums[l] == target){
            r = l;
            while(r < n && nums[r] == target){
                r++;
            }
            return new int[]{l,r - 1};
        }else {
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        int[] ans = searchRange(nums, 3);
        System.out.println(Arrays.toString(ans));
    }

}
