package com.company.Bishi.xiecheng.Day0919;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(--q >= 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int sum = 0;
            int i = 0;
            int j = 0;
            while(--k >= 0){
                if(i < n - 1){
                    i++;
                }else if(j < m - 1){
                    j++;
                }else {
                    j--;
                }
                sum += i * m + j;
            }
            System.out.println(sum);
        }
    }
}
