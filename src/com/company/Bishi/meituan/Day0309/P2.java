package com.company.Bishi.meituan.Day0309;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] nums = new int[n];
        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            sum += nums[i];
            if(nums[i] == 0){
                count++;
            }
        }

        for(int i = 0; i < q; i++){
            int L = sc.nextInt();
            int R = sc.nextInt();
            int min = sum + count * L;
            int max = sum + count * R;
            System.out.print(min + " " + max);
            System.out.println();
        }
    }
}
