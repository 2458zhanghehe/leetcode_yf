package com.company.Bishi.meituan.day0406;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        String[] strs = line.split(" ");

        int ans = 0;
        for(int i = 0; i < n; i++){
            int j = strs[i].indexOf("i");
            if(j == -1){
                ans++;
                continue;
            }
            if(j == 0 || strs[i].charAt(j - 1) == '+' || strs[i].charAt(j - 1) == '-'){
                continue;
            }
            boolean flag = true;
            while(--j >= 0){
                if(strs[i].charAt(j) == '+' || strs[i].charAt(j) == '-'){
                    break;
                }
                if(strs[i].charAt(j) != '0' && strs[i].charAt(j) != '.'){
                    flag = false;
                }
            }
            if(flag){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
