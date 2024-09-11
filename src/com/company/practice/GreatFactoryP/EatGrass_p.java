package com.company.practice.GreatFactoryP;

import java.io.StringReader;

public class EatGrass_p {
    public static String eatGrass1_p(int nums) {
        //nums = 0  后手
        //nums = 1  先手赢
        //nums = 2  后手赢
        //nums = 3  先手赢
        if (nums < 3) {
            return (nums == 2 || nums == 0) ? "后手" : "先手";
        }
        if ((nums & (~nums + 1)) == nums && (nums & 0X55555555) != 0) {
            return "先手";
        }
        int base = 1;
        while (base <= nums) {
            if (eatGrass1_p(nums - base) == "后手") {
                return "先手";
            }
            if (base > nums / 4) {
                return "后手";
            }
            base *= 4;
        }
        return "后手";
    }

    public static String eatGrass2_p(int nums) {
        return (nums % 5 == 2) || (nums % 5 == 0) ? "后手" : "先手";
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.println(eatGrass1_p(i));
        }
    }

}
