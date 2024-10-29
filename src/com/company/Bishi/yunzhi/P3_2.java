package com.company.Bishi.yunzhi;

import java.util.Scanner;

public class P3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean alreadyR = false;
            boolean alreadyE = false;

            for (int j = i; j < chars.length; j++) {
                if(chars[j] == 'r'){
                    alreadyR = true;
                }
                if(chars[j] == 'e'){
                    alreadyE = true;
                }
                if(chars[j] == 'd'){
                    break;
                }
                if(alreadyR && alreadyE){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
