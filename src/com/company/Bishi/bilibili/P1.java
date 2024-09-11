package com.company.Bishi.bilibili;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = n * (n - 1) + 1;
        System.out.println(ans);
    }
}
