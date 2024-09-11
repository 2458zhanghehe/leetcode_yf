package com.company.BitOperation;

//不做任何比较判断，位运算返回a,b较大值
public class GetMax {
    public static int getSymbol(int x) {
        return flip(((x >> 31) & 1));
    }

    public static int flip(int x) {
        return x ^ 1;
    }

    public static int getMax1(int a, int b) {   // 可能会溢出
        int c = a - b;
        int sc = getSymbol(c);
        return sc * a + flip(sc) * b;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = getSymbol(a);
        int sb = getSymbol(b);
        int sc = getSymbol(c);
        int difSab = sa ^ sb; //同符号为0，不同为1
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }


    public static void main(String[] args) {
        int a = -1900000001 - 1900000001;  // a溢出变为正数494967294.
        System.out.println(a);

        int aa = 2;
        int bb = -10;
        System.out.println(getMax1(aa, bb));
        System.out.println(getMax2(aa, bb));

        int aaa = -1900000001;
        int bbb = 1900000001;
        System.out.println(getMax1(aaa, bbb));
        System.out.println(getMax2(aaa, bbb));

    }
}
