package com.company.Bishi.tongcheng;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        int index = n - 2;
        while(index >= 0 && k > 0){
            int tmp = nums[index];
            for (int i = index; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[n - 1] = tmp;
            k--;
            index--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
