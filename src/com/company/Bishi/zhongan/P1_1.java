package com.company.Bishi.zhongan;

import java.util.Scanner;

public class P1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String curLine = sc.nextLine();
            String[] splits = curLine.split(" ");
            int len = Integer.parseInt(splits[0]);
            String a = splits[1];
            String b = splits[2];

            long aT = 0;
            long bT = 0;
            long tmp = 1;
            for (int j = len - 1; j >= 0; j--) {
                aT += (a.charAt(j) - 'a') * tmp;


                bT += (b.charAt(j) - 'a') * tmp;
                tmp *= 26;
            }
            if(aT >= bT){
                System.out.println(0);
            }else {
                System.out.println(bT - aT - 1);
            }
        }
    }
}
