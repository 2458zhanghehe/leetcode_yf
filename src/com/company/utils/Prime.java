package com.company.utils;

import java.util.ArrayList;
import java.util.List;

//求一个数的所有质数因子
public class Prime {
    private static List<Integer> get_divisors(int num) {
        int k = (int) Math.sqrt(num);
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= k; i++) {
            while(num != i) {
                if (num % i == 0) {
                    res.add(i);
                    num = num / i;
                } else {
                    break;
                }
            }
        }
        res.add(num);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> ans1 = get_divisors(5);
        System.out.println(ans1.toString());
        List<Integer> ans2 = get_divisors(100);
        System.out.println(ans2.toString());
        List<Integer> ans3 = get_divisors(168);
        System.out.println(ans3.toString());
    }
}
