package com.company.array;

import java.util.Arrays;

//数据均分最多能分成几组？
public class ArrayPartitionEqualSum {
    public static int maxGroups(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int n = nums.length;
        
        // 最大可能的组数就是数组长度
        for (int groups = n; groups >= 1; groups--) {
            if (totalSum % groups == 0) {
                int targetSum = totalSum / groups;
                if (canPartition(nums, new boolean[n], 0, groups, 0, targetSum)) {
                    return groups;
                }
            }
        }
        return 1;
    }

    private static boolean canPartition(int[] nums, boolean[] used, int startIndex, int groups, int currentSum, int targetSum) {
        if (groups == 0) {
            return true;
        }
        if (currentSum == targetSum) {
            return canPartition(nums, used, 0, groups - 1, 0, targetSum);
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            if (!used[i] && currentSum + nums[i] <= targetSum) {
                used[i] = true;
                if (canPartition(nums, used, i + 1, groups, currentSum + nums[i], targetSum)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 11, 6};
        System.out.println(maxGroups(nums));
    }
}
