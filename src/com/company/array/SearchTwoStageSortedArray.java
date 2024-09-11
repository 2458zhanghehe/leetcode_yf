package com.company.array;

public class SearchTwoStageSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(target >= nums[0]){
            int i = 0;
            while(i + 1 < n && nums[i + 1] > nums[i] && nums[i] < target){
                i++;
            }
            if(nums[i] == target){
                return i;
            }else if(i + 1 < n && nums[i + 1] == target){
                return i + 1;
            }else {
                return -1;
            }
        }else if(target <= nums[n - 1]){
            int i = n - 1;
            while(i - 1 >= 0 && nums[i - 1] < nums[i] && nums[i] > target){
                i--;
            }
            if(nums[i] == target){
                return i;
            }else if(i - 1 >= 0 && nums[i - 1] == target){
                return i - 1;
            }else {
                return -1;
            }
        }else {
            return -1;
        }
    }

    public static int search2(int[] nums, int target) {
        return process(nums,0,nums.length - 1,target);
    }

    private static int process(int[] nums, int l, int r, int target) {
        if(l > r){
            return -1;
        }
        if(target > nums[l]){
            return process(nums, l + 1, r, target);
        }else if(target < nums[r]){
            return process(nums, l, r - 1, target);
        }else if(target == nums[l]){
            return l;
        }else if(target == nums[r]){
            return r;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        int ans = search2(nums, target);
        System.out.println(ans);
    }
}
