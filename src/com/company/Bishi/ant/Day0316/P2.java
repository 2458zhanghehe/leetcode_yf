package com.company.Bishi.ant.Day0316;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int ans = 0;
        for(int i = 0; i < len - 1; i++){
            int left = cnt(str,0,i);
            int right = cnt(str,i + 1, len - 1);
            if(left == right){
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static int cnt(String str, int l, int r) {
        int fu = 0;
        int yuan = 0;
        for (int i = l; i <= r; i++) {
            char curChar = str.charAt(i);
            if(curChar == 'a' || curChar == 'e'
                    || curChar == 'i' || curChar == 'o'
                    || curChar == 'u'){
                yuan++;
            }else {
                fu++;
            }
        }
        return Math.abs(fu - yuan);
    }
}
