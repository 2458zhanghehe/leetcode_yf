package com.company.Bishi.Huawei.practice;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        char c = process(n,k);
        System.out.println(c);
    }

    private static char process(int n, int k){
        if(n == 1){
            return 'R';
        }
        int mid = 1 << (n - 2);
        if(k <= mid){
            return 'R' == process(n - 1, k) ? 'B' : 'R';
        }else {
            return process(n - 1,k - mid);
        }
    }
}
