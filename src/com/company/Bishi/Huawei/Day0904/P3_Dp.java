package com.company.Bishi.Huawei.Day0904;

import java.util.Arrays;
import java.util.Scanner;

//3 2
//        1 1
//        3 1 1
//        1 2 2
//        3 2 3
// error
public class P3_Dp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[][] kehu = new int[n][3];
        for (int i = 0; i < n; i++) {
            kehu[i][0] = scanner.nextInt();
            kehu[i][1] = scanner.nextInt();
            kehu[i][2] = scanner.nextInt();
        }
        Arrays.sort(kehu, (o1, o2) -> {return o1[2] - o2[2];});
        //dp[i][j] 表示服务完i客户，剩余j个装备
        double[][] dp = new double[n][k];
        for (int j = 0; j < k; j++) {
            dp[0][j] = getDistance(x, y, kehu[0][0], kehu[0][1]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Math.min(getDistance(kehu[i - 1][0], kehu[i - 1][1], x, y) + getDistance(x, y, kehu[i][0], kehu[i][1]) + (j == k - 1 ? dp[i - 1][0] : dp[i - 1][j + 1]),
                        getDistance(kehu[i - 1][0], kehu[i - 1][1], kehu[i][0], kehu[i][1]) + (j == k - 1 ? dp[i - 1][0] : dp[i - 1][j + 1]));
            }
        }

        double ans = 0;
        for (int j = 0; j < k; j++) {
            if(dp[n - 1][j] > ans){
                ans = dp[n - 1][j];
            }
        }
        System.out.println(ans);
    }

    private static double getDistance(int curX, int curY, int x, int y) {
        return Math.sqrt((curX - x) * (curX - x) + (curY - y) * (curY - y));
    }
}
