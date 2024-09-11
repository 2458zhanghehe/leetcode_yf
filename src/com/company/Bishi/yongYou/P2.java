package com.company.Bishi.yongYou;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == k){
                ans++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if((long)nums[i] + (long)nums[j] == k){
                    ans++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int l = j + 1; l < nums.length; l++) {
                    if((long)nums[i] + (long)nums[j] + (long)nums[l] == k){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
