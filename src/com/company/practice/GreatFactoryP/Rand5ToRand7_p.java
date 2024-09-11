package com.company.practice.GreatFactoryP;

public class Rand5ToRand7_p {
    public static int f5() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int rand01() {
        int tmp;
        do {
            tmp = f5();
        } while (tmp == 3);
        return tmp < 3 ? 0 : 1;
    }

    public static int rand5ToRand7() {
        int tmp;
        do {
            tmp = rand01() << 2 + rand01() << 1 + rand01();
        } while (tmp == 7);
        return tmp + 1;
    }

    public static int p1() {
        int tmp = (int) (Math.random() * 10) + 1;
        return tmp < 4 ? 0 : 1;
    }

    public static int sameP01() {
        int tmp;
        do {
            tmp = p1() << 1 + p1();
        } while (tmp == 3 || tmp == 0);
        return tmp == 1 ? 1 : 0;
    }
}
