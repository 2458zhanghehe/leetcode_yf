package com.company.practice.BitOperationP;

public class PrintB_p {
    public static void printB_p(int a) {
        for (int i = 31; i >= 0; i--) {
            System.out.print(((a & (1 << 31)) >> 31) & 1);
            a = a << 1;
        }
    }

    public static void main(String[] args) {
        printB_p(-1);
    }
}
