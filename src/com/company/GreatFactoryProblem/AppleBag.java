package com.company.GreatFactoryProblem;

public class AppleBag {
    public static int appleBag1(int nums) {
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

    //打表法，根据1常规打印输出，寻找规律，总结数学公式
    public static int appleBag2(int nums) {
        if (nums < 6 || (nums & 1) == 1) {
            return -1;
        }
        if (nums < 18) {
            if (nums == 6 || nums == 8) {
                return 1;
            }
            if (nums == 12 || nums == 14 || nums == 16) {
                return 2;
            }
            return -1;
        }
        return (nums - 2) / 8 + 1;
    }


    public static void main(String[] args) {
        for (int nums = 1; nums <= 100; nums++) {
            System.out.println(appleBag1(nums));
        }

        for (int nums = 1; nums <= 1000; nums++) {
            if (appleBag1(nums) != appleBag2(nums)) {
                System.out.println("error!");
            }
        }
    }
}
