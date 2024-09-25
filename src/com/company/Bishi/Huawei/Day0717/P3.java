package com.company.Bishi.Huawei.Day0717;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int k = sc.nextInt();
        int[][] nums = new int[k][2];
        for (int i = 0; i < k; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        Arrays.sort(nums, (o1, o2)->{return o1[0] - o2[0];});
        int ans = 0;
        for (int i = 0; i < k && amount > 0; i++) {
            while(amount > nums[i][0] && nums[i][1] > 0){
                amount -= nums[i][0];
                nums[i][1]--;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
