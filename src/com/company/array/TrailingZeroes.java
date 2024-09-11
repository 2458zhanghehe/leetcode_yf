package com.company.array;
//leetcode 172 阶乘后的零
public class TrailingZeroes {
    public static int trailingZeroes(int n) {
        int num = 0;
        int tmp = 5;
        while(n >= tmp){
            num += n / tmp;
            tmp *= 5;
        }
        return num;
    }

    public static void main(String[] args) {
        int num = trailingZeroes(51);
        System.out.println(num);
    }
}
