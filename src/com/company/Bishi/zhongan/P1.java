package com.company.Bishi.zhongan;

import java.util.Scanner;

public class P1 {
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
            int index = 0;
            while(index < len && a.charAt(index) == b.charAt(index)){
                index++;
            }
            if(index == len || a.charAt(index) > b.charAt(index)){
                System.out.println(0);
                continue;
            }
            int ans = 0;
            int tmp = 1;
            boolean jin = false;
            for (int j = len - 1; j >= index; j--) {
                int ai = a.charAt(j) - 'a';
                int bi = b.charAt(j) - 'a';
               if(bi > ai){
                   if(jin){
                       bi--;
                       jin = false;
                   }
                   ans += (bi - ai) * tmp;
               } else if (bi == ai) {

               } else {
                   ans += (26 - (ai -bi))* tmp;
                   jin = true;
               }
                tmp *= 26;
            }
            System.out.println(ans - 1);
        }
    }
}
