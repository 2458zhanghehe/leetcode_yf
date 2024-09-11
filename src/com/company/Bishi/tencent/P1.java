package com.company.Bishi.tencent;

import java.util.Arrays;

public class P1 {
    public static int[] bubbleSort(int[] nums){
        int len = nums.length;

        for(int i = 0; i < len; i++){
            boolean sorted = true;
            for(int j = 0; j < len - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    sorted = false;
                    swap(nums,j,j + 1);
                }
            }
            if(sorted){
                break;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2};
        int[] ans = bubbleSort(nums);
        System.out.println(Arrays.toString(ans));
    }
}
