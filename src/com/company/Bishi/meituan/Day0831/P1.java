package com.company.Bishi.meituan.Day0831;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] names = str.split(" ");
        int ans = 0;
        for(String name : names){
            if(name.length() == 0){
                continue;
            }
            char first = name.charAt(0);
            if(first >= 'A' && first <= 'Z'){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
