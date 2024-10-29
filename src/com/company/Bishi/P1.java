package com.company.Bishi;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] splits1 = str1.split(",");
        String[] splits2 = str2.split(",");
        int[] nums1 = new int[splits1.length];
        int[] nums2 = new int[splits2.length];
        for (int i = 0; i < splits1.length; i++) {
            nums1[i] = Integer.parseInt(splits1[i]);
        }
        for (int i = 0; i < splits2.length; i++) {
            nums2[i] = Integer.parseInt(splits2[i]);
        }

        int[] nums = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while(index < nums.length){
            for (int i = p1; i < p1 + n && i < nums1.length; i++) {
                nums[index++] = nums1[i];
            }
            p1 += n;
            for (int i = p2; i < p2 + n && i < nums2.length; i++) {
                nums[index++] = nums2[i];
            }
            p2 += n;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println(nums[nums.length - 1]);
    }
}
