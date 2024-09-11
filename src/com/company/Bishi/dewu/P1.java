package com.company.Bishi.dewu;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String strA = strs[0];
        String strB = strs[1];
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += compute(strA.charAt(i), strB.charAt(i));
        }
        System.out.println(ans);
    }

    private static int compute(char x, char y) {
        int a = x - '0';
        int b = y - '0';
        if(a >= b){
            return a - b;
        }else {
            return a + (10 - b);
        }
    }
}
