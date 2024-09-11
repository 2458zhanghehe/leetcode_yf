package com.company.GreatFactoryProblem;


//左86
public class EatGrass {
    public static String eatWin1(int nums) {
        // n = 1  先手
        // n = 2  后手
        // n = 3  先手
        // n = 4  先手
        if (nums < 4) {
            return (nums == 2 || nums == 0) ? "后手" : "先手";
        }
        if ((nums & (~nums + 1)) == nums && (nums & 0X55555555) != 0) {
            return "先手";
        }
        int base = 1;
        while (base <= nums) {
            if (eatWin1(nums - base) == "后手") {   //在子过程中后手赢就是当前过程的先手赢
                return "先手";
            }
//            if (base > nums / 4) {
//                break;
//            }
            base *= 4;
        }
        return "后手";
    }

    //打表法，根据1常规打印输出，寻找规律，总结数学公式
    public static String eatWin2(int nums) {
        return ((nums - 1) % 5 == 1 || (nums - 1) % 5 == 4) ? "后手" : "先手";
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.println(eatWin1(i));
        }
        for (int i = 1; i < 50; i++) {
            if (eatWin1(i) != eatWin2(i)) {
                System.out.println("error!");
            }
        }
    }

}
