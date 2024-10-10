package com.company.Bishi.Huawei.Day0925;

import java.util.Scanner;

// 俄罗斯方块
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] grid = new boolean[n][n];
        while(--k >= 0){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            grid[num1][num2] = true;
        }
        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j + 1 < n; j++) {

                if(!grid[i][j] && !grid[i + 1][j] && !grid[i][j + 1] && !grid[i + 1][j + 1]){
                    ans++;
                    grid[i][j] = true;
                    grid[i + 1][j] = true;
                    grid[i][j + 1] = true;
                    grid[i + 1][j + 1] = true;
                    j++;
                }
            }
        }
        System.out.println(ans);
    }
}
