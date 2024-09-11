package com.company.Bishi.meituan.Day0831;

import java.util.Arrays;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] location = new int[n];
        for (int i = 0; i < n; i++) {
            location[i] = sc.nextInt();
        }
        Arrays.sort(location);
        int min = k / n + (k % n == 0 ? 0 : 1);
        int delta;
        while(true){
            delta = min * n - k;
            for (int i = 0; i < n - 1; i++) {
                if(location[i] + min - 1 >= location[i + 1]){
                    delta -= location[i] + min - location[i + 1];
                }
            }
            if(delta >= 0){
                break;
            }else {
                min += -delta / n + (-delta % n == 0 ? 0 : 1);
            }
        }
        System.out.println(min);
    }
}
