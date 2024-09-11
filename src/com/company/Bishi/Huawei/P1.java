package com.company.Bishi.Huawei;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            //打印空格
            int kong = n - i;
            while(--kong >= 0){
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("/\\");
            }
            System.out.println();
        }
    }
}
