package com.company.Bishi.xiaomi;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long sum = 0;
        int count = 0;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(nums[i] < 0){
                count++;
                sum -= nums[i];
                minAbs = Math.min(minAbs, -nums[i]);
            }else if(nums[i] == 0){
                minAbs = 0;
            }else {
                sum += nums[i];
                minAbs = Math.min(minAbs, nums[i]);
            }
        }
        if((count & 1) == 1){
            sum -= 2L * minAbs;
        }
        System.out.println(sum);
    }
}
