package com.company.BitOperation;

//leetcode 67 二进制求和
public class AddBinary {
    public static String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        //不要用boolean，用数字可以计算取余取整，用boolean会有很多if-else
        int ca = 0;

        StringBuilder sb = new StringBuilder();
        while(p1 >= 0 && p2 >= 0){
            int ai = a.charAt(p1--) - '0';
            int bi = b.charAt(p2--) - '0';
            int sum = ai + bi + ca;
            sb.append(sum % 2);
            ca = sum / 2;
        }

        while(p1 >= 0){
            int ai = a.charAt(p1--) - '0';
            int sum = ai + ca;
            sb.append(sum % 2);
            ca = sum / 2;
        }

        while(p2 >= 0){
            int bi = b.charAt(p2--) - '0';
            int sum = bi + ca;
            sb.append(sum % 2);
            ca = sum / 2;
        }

        if(ca == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        String ans = addBinary(a, b);
        System.out.println(ans);
    }
}
