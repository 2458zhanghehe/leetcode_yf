package com.company.Dp;

// LCR 102 目标和
public class FindTargetSumWays {
    public static int findTargetSumWays(int[] nums, int target) {
        return process(0, 0, nums, target);
    }

    private static int process(int index, int curSum, int[] nums, int target) {
        if(index == nums.length){
            return curSum == target ? 1 : 0;
        }
        int ans1 = process(index + 1, curSum + nums[index], nums, target);
        int ans2 = process(index + 1, curSum - nums[index], nums, target);
        return ans1 + ans2;
    }

    public static int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 构成正target和负target的方法数是相同的，这里全部搞成正数
        target = target < 0 ? -target : target;
        int[][] dp = new int[nums.length + 1][sum + 1];
        dp[nums.length][target] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = (j - nums[i] >= 0 ? dp[i + 1][j - nums[i]] : 0)
                        + (j + nums[i] <= sum ? dp[i + 1][j + nums[i]] : 0);
            }
        }
        return dp[0][0];
    }
    //error，因为即使target1为正，去往target的过程可以为负。不太好搞

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        findTargetSumWays1(nums, target);
    }
}
