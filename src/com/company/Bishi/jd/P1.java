package com.company.Bishi.jd;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i][0] = sc.nextInt();
            lr[i][1] = sc.nextInt();
        }

        int min = 0;
        int max = n;
        for (int i = 0; i < m; i++) {
            min = Math.max(min, lr[i][0]);
            max = Math.min(max, lr[i][1]);
        }
        if(min > max) {
            System.out.println(0);
        }else {
            System.out.println(max - min + 1);
        }
    }
}
