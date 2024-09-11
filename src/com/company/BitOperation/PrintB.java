package com.company.BitOperation;

//按位打印整形
public class PrintB {
    //32位是0到31
    public static void printb(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //printb(8);
        int a = Integer.MAX_VALUE;
        printb(a);
        printb(a >> 1);  //带符号右移，缺位由符号位补充
        printb(a >>> 1); //不带符号右移，缺位直接由0补充
        System.out.println(a >> 1);
    }

}
