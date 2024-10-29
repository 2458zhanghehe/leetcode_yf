package com.company.Bishi.yunzhi;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chars = str.toCharArray();
        long ans = 0;
        int rLocate = -1;
        int eLocate = -1;
        int l = 0, r = 0;
        for (; r < chars.length; r++) {
            if(chars[r] == 'e'){
                eLocate = r;
            }
            if(chars[r] == 'r'){
                rLocate = r;
            }
            if(chars[r] == 'd'){
                if(rLocate >= 0 && eLocate >= 0){
                    int min = Math.min(rLocate, eLocate);
                    int max = Math.max(rLocate, eLocate);
                    ans += (long) (min - l + 1) * (r - max + 1);
                }
                rLocate = -1;
                eLocate = -1;
                l = r + 1;
            }
        }
        if(rLocate >= 0 && eLocate >= 0){
            int min = Math.min(rLocate, eLocate);
            int max = Math.max(rLocate, eLocate);
            ans += (long) (min - l + 1) * (r - max + 1);
        }
        System.out.println(ans);
    }
}
