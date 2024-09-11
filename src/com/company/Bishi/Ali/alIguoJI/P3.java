package com.company.Bishi.Ali.alIguoJI;

import java.util.Scanner;

public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(--t >= 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            int c3 = sc.nextInt();
            int ans2 = Coins2(c1, c2, c3, x, y);
//            int ans3 = Coins3(c1, c2, c3, x, y);
            System.out.println(ans2);
//            System.out.println(ans3);
        }
    }


    public static int Coins2(int x, int y, int z, int start, int end){
        return process2(0, x, y, z, start, end, x * ((end - start) / 2 + 1), end + 15);
    }

    private static int process2(int curCoin, int x, int y, int z, int cur,
                                int aim, int limitCoin, int limitAim) {
        if(cur == aim){
            return curCoin;
        }

        if(cur < 0){
            return Integer.MAX_VALUE;
        }

        if(curCoin > limitCoin){
            return Integer.MAX_VALUE;
        }

        if(cur > limitAim){
            return Integer.MAX_VALUE;
        }

        int p = Integer.MAX_VALUE;
        int p1 = process2(curCoin + x, x, y, z,cur + 2, aim, limitCoin, limitAim);
        if(p1 != Integer.MAX_VALUE){
            p = p1;
        }
        int p2 = process2(curCoin + y , x, y, z, cur - 3, aim, limitCoin, limitAim);
        if(p2 != Integer.MAX_VALUE){
            p = Math.min(p,p2);
        }
        int p3 = process2(curCoin + z, x, y, z, cur + 5, aim, limitCoin, limitAim);
        if(p3 != Integer.MAX_VALUE){
            p = Math.min(p,p3);
        }
        return p;
    }


    public static int Coins3(int x, int y, int z, int start, int end){
        int[][] dp = new int[x * ((end - start) / 2 + 1) + 1][end + 16];

        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = 0; j < dp[0].length; j++){
                if(j == end){
                    dp[i][j] = i;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if(i + x >= 0 && i + x < dp.length && j + 2 >= 0 && j + 2 < dp[0].length){
                    if(dp[i + x][j + 2] != Integer.MAX_VALUE){
                        min = dp[i + x][j + 2];
                    }
                }

                if(i + y >= 0 && i + y < dp.length && j - 3 >= 0 && j - 3 < dp[0].length){
                    if(dp[i + y][j * 2] != Integer.MAX_VALUE){
                        min = Math.min(min, dp[i + y][j * 2]);
                    }
                }

                if(i + z >= 0 && i + z < dp.length && j + 5 >= 0 && j + 5 < dp[0].length){
                    if(dp[i + z][j - 2] != Integer.MAX_VALUE){
                        min = Math.min(min, dp[i + z][j - 2]);
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[0][start];
    }
}
