package com.company.GreatFactoryProblem;

import org.omg.CORBA.INTERNAL;

//leetcode 50
public class Pow {
    public static double pow(double x, int n) {
        if (n == 0) {
            return 1D;
        }
        int p = Math.abs((n == Integer.MIN_VALUE) ? n + 1 : n);  //-2147483648 : 2147483647 系统最小没法取相反数
        double tmp = x;
        double ans = 1D;     //double范围-2^1074 ~ 2^1024-1 装得下
        while (p != 0) {
            if ((p & 1) != 0) {
                ans *= tmp;
            }
            tmp *= tmp;
            p = p >> 1;
        }
        if (n == Integer.MIN_VALUE) {
            ans = ans * x;
        }
        if (n < 0) {
            ans = 1D / ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(pow(5, Integer.MIN_VALUE));
    }
}
