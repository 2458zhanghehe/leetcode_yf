package com.company.binarySearch;

public class BinarySearch {
    public static int findLeftBoundary(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 5};
        int target = 2;
        int result = findLeftBoundary(nums, target);
        System.out.println("The left boundary index is: " + result);
    }
}