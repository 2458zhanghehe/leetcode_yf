package com.company.Bishi.Ali.xiaohongshu;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if(nums[i] == max){
                ans[i] = sum;
                continue;
            }
            int otherSum = sum - nums[i];
            int delta = max * (n - 1) - otherSum;
            if(max - nums[i] <= delta){
                ans[i] = (max - nums[i]) * 2 + sum - 1;
            }else {
                int cur = nums[i];
                int curMax = max;
                cur += delta;
                ans[i] = sum + delta * 2;
                while(curMax - cur >= n - 1){
                    ans[i] += 2 * (n - 1);
                    curMax++;
                    cur += n - 1;
                }
                ans[i] += (curMax - cur) * 2 - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }
}
