package com.company.Bishi.Huawei.Day0925;

import java.util.ArrayList;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        process(0, nums, T, list, 0);

        int ans = 0;
        for(Integer cur : list){
            if(cur > T){
                continue;
            }
            if(cur == T){
                System.out.println(cur);
                return;
            }
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }

    private static void process(int index, int[] nums, int t, ArrayList<Integer> list, int sum) {
        if(index == nums.length){
            list.add(sum);
            return;
        }

        //不要
        process(index + 1, nums, t, list, sum);
        //要
        if(sum + nums[index] <= t){
            process(index + 1, nums, t, list, sum + nums[index]);
        }

    }
}
