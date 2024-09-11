package com.company.Bishi.meituan.day0406;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = 0;
        char[] chars = {'m','e','i','t','u','a','n'};
        for(int i = 0; i < 7; i++){
            if(str.charAt(i) != chars[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
