package com.company.Bishi.yongYou;

import java.util.Scanner;

public class P3 {
    public static int goldenFinger (int n, int m) {
        if(m == 1 && n == 1){
            return 1;
        }
        int ans = 0;
        while(m > 1 && n > 1){
            if(m > n){
                ans++;
                m -= n;
            }else if(m < n){
                ans++;
                n -= m;
            }else{
                ans++;
                return ans;
            }
        }
        if(m == 1){
            ans += n;
        }
        if(n == 1){
            ans += m;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(goldenFinger(1, 1));
    }
}
