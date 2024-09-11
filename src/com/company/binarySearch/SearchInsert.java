package com.company.binarySearch;

//LCR 068 搜索插入位置
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while(l < r){
            int mid = l + ((r - l) >> 1);
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid;
            }else {
                return mid;
            }
        }
        return l;
    }
}
