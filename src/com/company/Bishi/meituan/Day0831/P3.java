package com.company.Bishi.meituan.Day0831;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        while(--q >= 0){
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int tuanNum = 0;
            for (int i = l; i <= r; i++) {
                if(nums[i] > tuanNum){
                    tuanNum = nums[i];
                }
            }

            boolean win = false;
            int len = Integer.MAX_VALUE;
            for (int i = l - 1; i >= 0; i--) {
                if(nums[i] > tuanNum){
                    len = r - i + 1;
                    win = true;
                    break;
                }
            }

            for (int i = r + 1; i < n; i++) {
                if(nums[i] > tuanNum){
                    len = Math.min(i - l + 1, len);
                    win = true;
                    break;
                }
            }
            if(win){
                System.out.println("win");
                System.out.println(len);
            }else {
                System.out.println("lose");
                System.out.println(2);
            }
        }
    }
}
