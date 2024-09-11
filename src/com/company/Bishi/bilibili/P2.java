package com.company.Bishi.bilibili;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        if(((n - k + 1) & 1) == 1){
            String s1 = str.substring(0,k - 1);
            String s2 = str.substring(k - 1);
            sb.append(s2);
            for(int i = s1.length() - 1; i >= 0; i--){
                sb.append(s1.charAt(i));
            }
            System.out.println(sb.toString());
        }else {
            String s1 = str.substring(0,k - 1);
            String s2 = str.substring(k - 1);
            sb.append(s2);
            sb.append(s1);
            System.out.println(sb.toString());
        }
    }
}
