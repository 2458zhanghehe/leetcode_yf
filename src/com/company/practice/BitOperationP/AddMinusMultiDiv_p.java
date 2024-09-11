package com.company.practice.BitOperationP;

public class AddMinusMultiDiv_p {
    public static int Add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int Minus(int a, int b) {
        return Add(a, ~b + 1);
    }

    public static int Multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = Add(res, a);
            }
            b = b >>> 1;
            a = a << 1;
        }
        return res;
    }

    public static int Div(int a, int b) {
        int AbsA = a < 0 ? Add(~a, 1) : a;
        int AbsB = b < 0 ? Add(~b, 1) : b;
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            int x = AbsA >> i;
            if ((AbsA >> i) >= AbsB) {
                res = res | (1 << i);
                AbsA -= AbsB << i;
                //AbsA = Minus(AbsA,AbsB<<i);
            }
        }
        return ((a < 0) == (b < 0)) ? res : Add(~res, 1);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        System.out.println(Add(a, b));
        System.out.println(Minus(a, b));
        System.out.println(Multi(a, b));
        System.out.println(Div(a, b));
    }
}
