package com.company.binarySearch;

//leetcode162  左3
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        int N = nums.length - 1;
        if(nums[N] > nums[N - 1]){
            return N;
        }

        int L = 1;
        int R = N - 1;
        while(L <= R){
            int mid = L + ((R - L) >> 1);
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid + 1] > nums[mid]){
                L = mid + 1;
            }else {
                R = mid - 1;
            }
        }
        return -1;
    }
}
