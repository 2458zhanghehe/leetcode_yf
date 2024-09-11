package com.company.Bishi.meituan.practice;

import java.util.Scanner;

public class Juan1_P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for(int i = 0; i < n; i++){
            ints[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
//        System.out.println(Arrays.toString(ints));
//        System.out.println(x);
//        System.out.println(y);

        for(int i = 0; i < n; i++){
            if(ints[i] == x || ints[i] == y){
                boolean flag = (ints[i + 1] == x) || (ints[i + 1] == y);
                System.out.println(flag ? "Yes" : "No");
                break;
            }
        }
    }
}
