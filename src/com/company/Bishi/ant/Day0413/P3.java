package com.company.Bishi.ant.Day0413;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        List<Integer> list = get_divisors(sum);
        list = list.stream().sorted().distinct().collect(Collectors.toList());

        if(list.size() == 1){
            System.out.println(1);
            return;
        }

        for (int i = list.size() - 1; i >= 0 ; i--) {
            Integer cur = list.get(i);
            //boolean can = process(nums, 0, 0, cur);
            boolean can = dp(nums, sum, cur);
            if(can){
                System.out.println(cur);
                return;
            }

        }
    }

    private static boolean dp(int[] nums, int sum, Integer aim) {
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for(int j = 0; j < sum + 1; j++){
            if(j % aim == 0){
                dp[len][j] = true;
            }
        }
        for(int i = len - 1; i >= 0; i--){
            for(int j = 0; j < sum; j++){
                if(j % aim == 0){
                    dp[i][j] = true;
                }else {
                    dp[i][j] = dp[i + 1][j] || (j + nums[i] < sum + 1 && dp[i + 1][j + nums[i]]);
                }
            }
        }
        return dp[0][0];
    }

    private static boolean process(int[] nums, int i, int already, Integer aim) {
        if(i == nums.length){
            return already % aim == 0;
        }
        if(already == aim){
            return true;
        }
        //不要
        boolean p1 = process(nums,i + 1, already,aim);
        //要
        boolean p2 = process(nums, i + 1, already + nums[i], aim);
        return p1 || p2;
    }

    private static List<Integer> get_divisors(int num) {
        int k = (int) Math.sqrt(num);
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= k; i++) {
            while(num != i) {
                if (num % i == 0) {
                    res.add(i);
                    num = num / i;
                } else {
                    break;
                }
            }
        }
        res.add(num);
        return res;
    }
}
