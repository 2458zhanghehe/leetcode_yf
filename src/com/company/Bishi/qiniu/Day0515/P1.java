package com.company.Bishi.qiniu.Day0515;

import java.util.Arrays;

public class P1 {
    //
    public static int[] quickSort(int[] nums){
        if(nums == null || nums.length < 2){
            return nums;
        }

        process(nums, 0, nums.length - 1);
        return nums;
    }

    private static void process(int[] nums, int l, int r) {
        if(l >= r){
            return;
        }
        int index = (int)(Math.random()*(r - l)) + l;
        swap(nums, index, r);
        int p1 = l - 1;
        int p2 = r;
        for (int i = l; i < p2;) {
            if(nums[i] < nums[r]){
                swap(nums, ++p1, i++);
            }else if(nums[i] > nums[r]){
                swap(nums, --p2, i);
            }else {
                i++;
            }
        }
        swap(nums, p2++, r);
        process(nums, l, p1);
        process(nums, p2, r);
    }


    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,-12,6};
        int[] ans = quickSort(nums);
        System.out.println(Arrays.toString(ans));
    }
}
