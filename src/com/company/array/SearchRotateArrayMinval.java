package com.company.array;

public class SearchRotateArrayMinval {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        if(nums[0] < nums[n - 1]){
            return nums[0];
        }else {
            int i = n - 1;
            while(nums[i - 1] < nums[i]){
                i--;
            }
            return nums[i];
        }
    }
}
