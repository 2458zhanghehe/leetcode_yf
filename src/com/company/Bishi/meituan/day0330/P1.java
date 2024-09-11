package com.company.Bishi.meituan.day0330;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int a = (k - 2 * x - y)/3;
        int b = (k + x + 2 * y)/3;
        int c = k - a - b;
        System.out.println(a + " " + b + " " + c);
    }
}
