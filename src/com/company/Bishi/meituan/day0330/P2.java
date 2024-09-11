package com.company.Bishi.meituan.day0330;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            if(nums[i] > max){
                max = nums[i];
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] * 2 > max){
                System.out.print((nums[i] * 2) + " ");
            }else {
                System.out.print(max + " ");
            }
        }
    }
}
