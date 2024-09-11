package com.company.Bishi.Ali.DaWenYu;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    int Edge1X = x1 - x2;
                    int Edge1Y = y1 - y2;
                    int Edge2X = x1 - x3;
                    int Edge2Y = y1 - y3;
                    int Edge3X = x2 - x3;
                    int Edge3Y = y2 - y3;

                    if((Edge1X == 0 && Edge2X == 0) || (Edge1X != 0 && Edge2X != 0 && Edge2Y * 1.0 / Edge2X == Edge1Y * 1.0 / Edge1X)){
                        continue;
                    }

                    int g1 = gcd(Math.abs(Edge1X), Math.abs(Edge1Y));
                    int g2 = gcd(Math.abs(Edge2X), Math.abs(Edge2Y));
                    int g3 = gcd(Math.abs(Edge3X), Math.abs(Edge3Y));
                    ans = Math.max((long)g1 + (long)g2 + (long)g3, ans);
                }
            }
        }
        System.out.println(ans);
    }
    public static int gcd(int num1, int num2){
        while(num2 != 0){
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

}
