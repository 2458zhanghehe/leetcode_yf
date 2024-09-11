package com.company.BitOperation;

public class Is2Power {
    public static boolean is2Power(int x) {
        return (x & (~x + 1)) == x;
    }

    public static boolean is4Power(int x) {
        return ((x & (~x + 1)) == x) && ((x & 0x55555555) != 0);   //0x55555555即为0101010..0101;
    }

    public static void main(String[] args) {
        System.out.println(is4Power(15));
    }
}
