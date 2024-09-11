package com.company.Bishi.meidi;

import java.util.Scanner;

public class WuP2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        if(str.length() <= n || n == 1){
            System.out.println(str);
            return;
        }
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++){
            boolean flag = true;
            int j = i;
            while(j < chars.length){
                stringBuilder.append(chars[j]);
                if(i == 0 || i == n - 1){
                    j = j + 2 * (n - 1);
                }else {
                    if(flag){
                        j += 2 * (n - 1 - i);
                    }else {
                        j += 2 * i;
                    }
                    flag = !flag;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
