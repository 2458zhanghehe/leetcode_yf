package com.company.Bishi.Ali.Taotian;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(--t >= 0){
            int n = sc.nextInt();
            int[] nums = new int[n + 1];
            nums[n] = sc.nextInt();
            int k = sc.nextInt();
            for(int i = n; i > 0; i--){
                nums[i - 1] = nums[i] % i;
            }
            System.out.println(nums[k  - 1]);
        }
    }
}
