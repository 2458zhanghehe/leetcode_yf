package com.company.Bishi.hengsheng;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int m = str1.length();
        int n = str2.length();

        int j = 0;
        for(int i = 0; i < m; i++){
            if(j >= n){
                System.out.println(0);
                return;
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
                continue;
            }
            if(str2.charAt(j) == '.'){
                j++;
                continue;
            }
            while(j + 1 < n && str2.charAt(j + 1) == str2.charAt(j)){
                j++;
            }
            if(j + 1 < n && str2.charAt(j + 1) == '*'){
                j += 2;
                i--;
            }else {
                System.out.println(0);
                return;
            }
            if(j >= n && i != m - 1){
                System.out.println(0);
                return;
            }
        }
        if(j < n){
            System.out.println(0);
        }else {
            System.out.println(1);
        }

    }
}
