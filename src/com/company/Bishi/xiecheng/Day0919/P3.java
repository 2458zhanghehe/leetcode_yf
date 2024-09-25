package com.company.Bishi.xiecheng.Day0919;

import java.util.ArrayList;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();

        int[] nums = new int[n];
        int min = Integer.MAX_VALUE;
        int max  =Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int left = min;
        int right = max;
        int mid;
        while(left < right){
            mid = ((right - left + 1) >> 1) + left;  //改为向上取整
            if(isOk(mid, k, l, nums)){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }

    private static boolean isOk(int mid, int k, int l, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < mid){
                list.add(i);
            }
        }
        if(list.size() > k * l){
            return false;
        }
        while(--k >= 0 && !list.isEmpty()){
            Integer first = list.remove(0);
            while(!list.isEmpty() && list.get(0) < first + l){
                list.remove(0);
            }
        }
        return list.isEmpty();
    }
}
