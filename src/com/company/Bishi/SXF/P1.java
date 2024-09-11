package com.company.Bishi.SXF;

import java.util.Arrays;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean[] appear = new boolean[26];
        int count = str.length();
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if(appear[index]){
                count--;
            }else {
                appear[index] = true;
            }
        }
        System.out.println((1 << count) - 1);
    }
}
