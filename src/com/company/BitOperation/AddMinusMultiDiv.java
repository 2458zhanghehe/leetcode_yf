package com.company.BitOperation;

import com.company.sort.Code06_Comparator;

//不使用 + - * / 实现加减乘除
public class AddMinusMultiDiv {
    //不需要考虑a + b本身就是溢出的情况   LCR 190
    public static int Add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = sum ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int Minus(int a, int b) {
        return Add(a, ~b + 1);
    }

    public static int Multi(int a, int b) {
        int sum = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                sum = Add(sum, a);
            }
            a = a << 1;
            b = b >>> 1;
        }

        return sum;
    }

    public static int Div(int a, int b) {
        int x = a < 0 ? Add(~a, 1) : a;
        int y = b < 0 ? Add(~b, 1) : b;
        int res = 0;
        for (int i = 30; i >= 0; i = Minus(i, 1)) {
            if ((x >> i) >= y) {                //y左移的话，需要改为if((y<<i) <= x) 但y左移较大位数容易
                res = Add(res, 1 << i);     //溢出变为0或负数(当mostrightone移动到符号位时)
//                res = res | (1<<i);
                x = Minus(x, y << i);
            }
        }
        return (a < 0) ^ (b < 0) ? Add(~res, 1) : res;
    }


    public static void main(String[] args) {
        System.out.println(Add(3, 6));
        System.out.println(Minus(8, 14));
        System.out.println(Multi(-8, -6));
        System.out.println(Div(480, -8));
        System.out.println(2 << 29);
        System.out.println(2 << 30);
        System.out.println(2 << 31);
    }
}
