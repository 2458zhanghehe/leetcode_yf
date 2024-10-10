package com.company.Bishi.ant.Day0929;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(--q  >= 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            String t = sc.nextLine();
            int[][] count = new int[k][26];

            for (int i = 0; i < s.length(); i++) {
                count[i % k][s.charAt(i) - 'a']++;
            }

            for (int i = 0; i < t.length(); i++) {
                if(count[i % k][t.charAt(i) - 'a'] == 0){
                    System.out.println("No");
                    return;
                }
                count[i % k][t.charAt(i) - 'a']--;
            }
            System.out.println("Yes");
        }
    }
}
