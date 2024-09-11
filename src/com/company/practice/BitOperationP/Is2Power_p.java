package com.company.practice.BitOperationP;

public class Is2Power_p {
    public static boolean is2Power(int a) {
        return (a & (~a + 1)) == a;
    }

    public static boolean is4Power(int a) {
        return ((a & (~a + 1)) == a) && ((a & 0x55555555) != 0);
    }

    public static void main(String[] args) {
        int a = 8;
        System.out.println(is2Power(a));
        System.out.println(is4Power(a));
    }
}
