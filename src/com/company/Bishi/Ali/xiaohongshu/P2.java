package com.company.Bishi.Ali.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] fans = new int[n];
        for (int i = 0; i < n; i++) {
            fans[i] = sc.nextInt();
        }
        Arrays.sort(fans);
        int ans = process(fans, 0, n, x);
        int ans_dp = process(fans, 0, n, x);
        System.out.println(ans);
        System.out.println(ans_dp);
    }

    private static int process(int[] fans, int i, int n, int x) {
        if(i == n){
            return x == 0 ? 0 : -1;
        }
        if(x == 0){
            return 0;
        }
        if(x < 0){
            return -1;
        }
        //不推荐
        int p1 = process(fans, i + 1, n, x);
        //推荐一次
        int p2 = process(fans, i + 1, n, x - fans[i] / 2);
        //推荐多次
        int p3 = process(fans, i + 1, n, x - fans[i]);

        if(p1 == -1 && p2 == -1 && p3 == -1){
            return -1;
        }
        return Math.min(p1 == -1 ? Integer.MAX_VALUE : p1, Math.min(p2 == -1 ? Integer.MAX_VALUE : p2 + 1, p3 == -1 ? Integer.MAX_VALUE : p3 + 1));
    }


    private static int dp(int[] fans, int index, int n, int x){
        int[][] dp = new int[n + 1][x + 1];
        for (int j = 1; j < x + 1; j++) {
            dp[n][j] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for(int j = 1; j < x + 1; j++){
                int p1 = dp[i + 1][j];
                int p2 = (j - fans[i] / 2) >= 0 ? dp[i + 1][j - fans[i]/2] : -1;
                int p3 = (j - fans[i]) >= 0 ? dp[i + 1][j - fans[i]] : -1;
                if(p1 == -1 && p2 == -1 && p3 == -1){
                    dp[i][j] = -1;
                }else {
                    dp[i][j] = Math.min(p1 == -1 ? Integer.MAX_VALUE : p1, Math.min(p2 == -1 ? Integer.MAX_VALUE : p2 + 1, p3 == -1 ? Integer.MAX_VALUE : p3 + 1));
                }
            }
        }
        return dp[0][x];
    }
}
