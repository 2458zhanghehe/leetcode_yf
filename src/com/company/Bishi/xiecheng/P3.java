package com.company.Bishi.xiecheng;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        long min = Long.MAX_VALUE;

        int ansL = 0;
        int ansR = 0;

        for(int i = 0; i < n; i++){
            if((nums[i] & 1) != 0){
                continue;
            }
            int R = i;
            long sum = nums[i];
            if(sum < min){
                min = sum;
                ansL = i;
                ansR = i;
            }
            while((R + 1) < n && (nums[R + 1] & 1) == 0){
                R++;
                sum += nums[R];
                if(sum < min){
                    min = sum;
                    ansL = i;
                    ansR = R;
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++){
            if(i >= ansL && i <= ansR){
                ans += nums[i] / 2;
            }else {
                ans += nums[i];
            }
        }
        System.out.println(ans);
    }
}
