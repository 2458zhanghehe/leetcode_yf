package com.company.Bishi.Huawei.practice;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
//        int ans = process(nums, 0 ,m);
        int ans = dpT(nums, m);
        System.out.println(ans);
    }

    private static int process(int[] nums, int index, int res){
        if(index == nums.length){
            return 0;
        }

        int max = 0;
        for(int i = 0; i <= res/(index + 1); i++){
            int ans = process(nums, index + 1, res - (index + 1) * i);
            max = Math.max(ans + nums[index] * i, max);
        }
        return max;
    }

    private static int dpT(int[] nums, int m){
        int[][] dp = new int[nums.length + 1][m + 1];
        for(int j = 0; j < m + 1; j++){
            dp[nums.length][j] = 0;
        }

        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < m + 1; j++){
                int max = 0;
                for(int k = 0; k <= j / (i + 1); k++){
                    int cur = dp[i + 1][j - (i + 1) * k];
                    max = Math.max(cur + nums[i] * k, max);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][m];
    }
}
