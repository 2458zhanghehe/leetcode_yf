package com.company.Bishi.leihuo;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt() + 1;
        int y = sc.nextInt() + 1;
        System.out.println(x + y - gcd(x, y));

    }

    private static int gcd(int x, int y) {
        if(y == 0){
            return x;
        }
        return gcd(y, x % y);
    }
}
