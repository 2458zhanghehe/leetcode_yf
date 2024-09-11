package com.company.Bishi.meituan.practice;

import java.util.Scanner;

public class Juan1_P5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if((i & 1) == 1){
                ans[i] = n - (i + 1)/2 + 1;
            }else {
                ans[i] = i/2 + 1;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
