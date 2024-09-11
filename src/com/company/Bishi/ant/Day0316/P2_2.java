package com.company.Bishi.ant.Day0316;

import java.util.Scanner;

public class P2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();

        int leftFu = 0;
        int leftYuan = 0;
        int rightFu = 0;
        int rightYuan = 0;
        for(int i = 0; i < len; i++){
            char curChar = str.charAt(i);
            if(curChar == 'a' || curChar == 'e'
                    || curChar == 'i' || curChar == 'o'
                    || curChar == 'u'){
                rightYuan++;
            }else {
                rightFu++;
            }
        }

        int ans = 0;
        //[0 - i] [i + 1, len - 1]
        for(int i = 0; i < len - 1; i++){
            char curChar = str.charAt(i);
            if(curChar == 'a' || curChar == 'e'
                    || curChar == 'i' || curChar == 'o'
                    || curChar == 'u'){
                rightYuan--;
                leftYuan++;
            }else {
                rightFu--;
                leftFu++;
            }
            if(Math.abs(leftFu - leftYuan) == Math.abs(rightFu - rightYuan)){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
