package com.company.Bishi.meidi;

import java.util.Scanner;

public class P2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        if(split.length < 2){
            System.out.println(-1);
            return;
        }

        long num1 = Long.parseLong(split[0]);
        long num2 = Long.parseLong(split[1]);

        long small = Math.min(num1, num2);
        long big = small == num1 ? num2 : num1;

        long ans = 0;
        for(long i = 1; i < small; i++){
            if(small % i == 0 && big % i == 0){
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
