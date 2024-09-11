package com.company.Bishi.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int d = sc.nextInt();

            Integer[] nums = new Integer[n];
            for(int j = 0; j < n; j++){
                nums[j] = sc.nextInt();
            }

            //自定义排序必须使用包装类
            Arrays.sort(nums, new MyCompare());

            int sum = 0;
            for(int j = d; j < n; j++){
                if(j - d < m){
                    sum += -k * nums[j];
                }else {
                    sum += nums[j];
                }
            }

            System.out.println(sum);
        }
    }

    public static class MyCompare implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}


