package com.company.Bishi.xiaomi;

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
            int l = 0;
            int r = 0;
            int flip = 0;
            while(r < n){
                if(nums[r] == 1){
                    flip++;
                }
                while(flip > 1){
                    if(nums[l] == 1){
                        flip--;
                    }
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
                r++;
            }
            System.out.println(ans);
        }
    }
}
