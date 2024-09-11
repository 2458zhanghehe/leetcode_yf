package com.company.Bishi.manbang;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int d = sc.nextInt();
        int x = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            int ans = 0;
            if(t >= 2 *d + x){
                ans = i * t + d + x;
                System.out.println(ans);
            }else {
                ans = Math.min(i * t + d + i * x, i * (2 * d + x));
                System.out.println(ans);
            }
        }
    }
}
