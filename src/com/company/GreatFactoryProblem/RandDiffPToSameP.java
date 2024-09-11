package com.company.GreatFactoryProblem;

public class RandDiffPToSameP {
    //给定函数f，以0.3概率生成0，以0.7概率生成1
    public static int f() {
        int tmp = (int) (Math.random() * 10) + 1;
        return tmp < 4 ? 0 : 1;
    }

    //构建函数等概率生成0和1
    public static int rand01() {
        int tmp;
        do {
            tmp = (f() << 1) + f();
        } while (tmp == 0 || tmp == 3);
        return tmp == 1 ? 0 : 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.print(rand01());
        }
    }
}
