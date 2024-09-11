package com.company.utils;

//求num1和num2的 最大 公因数 eg: 12 16  4
public class Gcd {
    public static int gcd(int num1, int num2){
        while(num2 != 0){
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

    //一正一负、都为负数得最大公因数都是正数，即整数得最大公因数都是正数，可以直接取绝对值再代入gcd
    public static void main(String[] args) {
        int gcd = gcd(10, Math.abs(-5));
        System.out.println(gcd);
    }


}
