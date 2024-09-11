package com.company.Bishi.yongYou;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(" ");
        int[] nums = new int[splits.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        int next = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(next >= nums.length - 1){
                System.out.println("true");
                return;
            }
            next = Math.max(next, i + nums[i]);
            if(i == next){
                System.out.println("false");
                return;
            }
        }
    }
}
