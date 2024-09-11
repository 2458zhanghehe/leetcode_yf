package com.company.Bishi.xiecheng;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long bigNum = 1;
        while(n-- > 0){
            int x = sc.nextInt();
            bigNum *= jieNulti(x);
        }
        System.out.println(Math.round(count(bigNum) % (1e9 + 7)));
    }

    private static int count(long x) {
        int s = 1;
        for(long i = 2; i * i <= x; i++){
            if(x % i == 0){
                int a = 0;
                while(x % i == 0){
                    x /= i;
                    a++;
                }
                s = s * (a + 1);
            }
        }
        if(x > 1){
            s = s * 2;
        }
        return s;
    }

    private static long jieNulti(int x) {
        if(x <= 1){
            return 1;
        }
        return x * jieNulti(x - 1);
    }
}
