package com.company.Bishi.redbook;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] articles = new int[n];
        for (int i = 0; i < n; i++) {
            articles[i] = sc.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((articles[i] ^ articles[j]) == k){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
