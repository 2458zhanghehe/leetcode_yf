package com.company.Bishi.ant.Day0330;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if(cur == 0){
                count1++;
            }else if(cur == 1){
                count2++;
            }else if(cur == -1){
                count3++;
            }
        }

        int ans0 = ((2 << (count1 - 1)) - 1) * 2 << (count2 + count3 - 1);
        int ans1 = 0;
        for (int i = 1; i <= count3; i += 2) {
            ans1 += combination1(count3, i) * (2 << (count2 - 1));
        }
        int ans2 = 0;
        for(int i = 0; i <= count3; i += 2){
            ans2 += combination1(count3, i) * (2 << (count2 - 1));
        }
        ans2 -= 1;  //不能两边都不雅

    }

    private static int combination1(int n, int k) {
        int a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(int i=1;i<=k;i++) {
            a*=(n+1-i);
            b*=i;
        }
        return a/b;
    }
}
