package com.company.GreatFactoryProblem;

//leetcode470
public class Rand5ToRand7 {
    //f5为给定函数
    public static int f5() {
        return (int) (Math.random() * 5) + 1;
    }

    //构建1到7的随机生成函数
    public static int rand5ToRand7() {
        int tmp;
        do {
            tmp = (rand01() << 2) + (rand01() << 1) + rand01();  //括号不能少
        } while (tmp == 7);
        return tmp + 1;
    }

    public static int rand01() {
        int tmp;
        do {
            tmp = f5();
        } while (tmp == 3);
        return tmp < 3 ? 0 : 1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.print(rand5ToRand7());
        }
    }
}
