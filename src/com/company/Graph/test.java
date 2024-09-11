package com.company.Graph;

import java.util.ArrayList;

public class test {
    //请写一个函数，实现两个整数的和，要求空间复杂度和时间复杂度都为最优

    public static int getSum(int a, int b) {
        // 当进位为 0 时结束
        while (b != 0) {
            // 不进位的加法结果
            int sum = a ^ b;
            // 进位
            int carry = (a & b) << 1;
            // 更新 a 为不进位的结果，更新 b 为进位
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5, -10));
        ArrayList<Integer> list = new ArrayList<>();
    }
}