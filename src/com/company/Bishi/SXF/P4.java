package com.company.Bishi.SXF;

import java.util.Arrays;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        if(k < m + n){
            System.out.println(0);
            return;
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        System.out.println(dp[n]);
    }
}
