package com.company.Bishi.jd;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(--t >= 0){
            int n = sc.nextInt();
            int L = sc.nextInt();
            int m = sc.nextInt();
            int b = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            if(m * b > L){
                System.out.println("No");
                continue;
            }

            if(m * b == L || m >= n){
                System.out.println("Yes");
                continue;
            }

            int cur = arr[0];
            int need = n;
            for (int i = 1; i < n; i++) {
                if(cur + b > arr[i]){
                    need--;
                }else {
                    cur = arr[i];
                }
            }
            if(m >= need) {
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
