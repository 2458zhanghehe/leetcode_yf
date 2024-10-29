package com.company.Bishi.yunzhi;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(--t >= 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if(nums[i] + nums[j] == (nums[i] ^ nums[j])){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
