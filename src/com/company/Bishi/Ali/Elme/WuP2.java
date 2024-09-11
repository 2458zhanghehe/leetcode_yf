package com.company.Bishi.Ali.Elme;

import java.util.Scanner;

public class WuP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            long k = sc.nextLong();
            int[] nums = new int[n];
            for(int j = 0; j < n; j++){
                nums[j] = sc.nextInt();
            }
            if(n == 1){
                System.out.println("YES");
                continue;
            }
            int maxYin = gcd(nums[0],nums[1]);
            for(int j = 2; j < n; j++){
                maxYin = gcd(maxYin, nums[j]);
                if(maxYin == 1){
                    break;
                }
            }
            long need = 0;
            for(int j = 0; j < n; j++){
                need += nums[j]/maxYin - 1;
            }
            if(need > k){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }

    public static int gcd(int num1, int num2){
        while(num2 != 0){
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
