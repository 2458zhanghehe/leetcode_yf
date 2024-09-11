package com.company.practice.GreatFactoryP;

public class AppleBag_p {
    public static int appleBag_p(int nums) {
        if (nums < 6 || (nums & 1) == 1) {
            return -1;
        }
        int bag6 = 0;
        int bag8 = nums / 8;
        int rest = nums - bag8 * 8;
        for (; (rest < 24 && bag8 >= 0); bag8--) {
            if (rest % 6 == 0) {
                bag6 = rest / 6;
                return bag6 + bag8;
            }
            rest += 8;
        }
        return -1;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.println(appleBag_p(i));
        }
    }
}
