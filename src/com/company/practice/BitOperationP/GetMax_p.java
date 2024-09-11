package com.company.practice.BitOperationP;

public class GetMax_p {
    public static int flip(int x) {
        return x ^ 1;
    }

    public static int getMax1_p(int a, int b) {
        int c = a - b;
        int sc = c >>> 31;
        return (sc ^ 1) * a + sc * b;
    }

    public static int getMax2_p(int a, int b) {
        int c = a - b;
        int sa = a >>> 31;
        int sb = b >>> 31;
        int sc = c >>> 31;
        int diffS = sa ^ sb; //ab同符号为0
        int SameS = flip(diffS);
        int returnA = diffS * flip(sa) + SameS * flip(sc);
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

    public static void main(String[] args) {
        int a = -1900000001;
        int b = 1900000001;
        System.out.println(getMax1_p(a, b));
        System.out.println(getMax2_p(a, b));
    }
}
