package com.company.Bishi.Huawei.Day0911;

import java.util.Arrays;
import java.util.Scanner;

// 圣诞节礼盒
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] boxes = new int[n + 1][3];
        for (int i = 1; i < n + 1; i++) {
            boxes[i][0] = sc.nextInt();
            boxes[i][1] = sc.nextInt();
            boxes[i][2] = sc.nextInt();
        }

        Arrays.sort(boxes, (a,b)->{return a[2] - b[2];});
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if(boxes[i][0] > boxes[j][0] && boxes[i][1] > boxes[j][1] && boxes[i][2] > boxes[j][2]){
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i][2]);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n + 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
