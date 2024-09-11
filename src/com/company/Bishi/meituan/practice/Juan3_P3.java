package com.company.Bishi.meituan.practice;

import java.util.Scanner;

public class Juan3_P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] moneyEveryone = new long[m];
        for(int i = 0; i < n; i++){
            int k = sc.nextInt();
            int bill = sc.nextInt();

            long avg = (long)Math.ceil(1.0*bill/k);

            for(int j = 0; j < k - 1; j++){
                int person = sc.nextInt();
                moneyEveryone[person - 1] += avg;
            }
        }

        for(long tmp : moneyEveryone){
            System.out.print(tmp + " ");
        }
    }
}
