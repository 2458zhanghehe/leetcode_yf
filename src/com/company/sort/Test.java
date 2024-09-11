package com.company.sort;

import java.util.Arrays;

public class Test {
    public static int[] bubbleSort(int[] nums){
        if(nums == null || nums.length < 2){
            return nums;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static int[] quickSort(int[] nums){
        if(nums == null || nums.length < 2){
            return nums;
        }
        process(nums, 0, nums.length - 1);
        return nums;
    }
    public static void process(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int randomIndex = (int)(Math.random() * (r - l)) + l;
        swap(nums, randomIndex, r);

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
        swap(nums,r,p2++);
        process(nums, l, p1);
        process(nums, p2, r);
    }

    public static void main(String[] args) {
        int[] nums = {10,5,9,7,-1,3,-5};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
