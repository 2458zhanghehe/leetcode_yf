package com.company.GreatFactoryProblem;

public class SplitNbySM {
    public static int minOps(int n) {
        if (n < 2) {
            return 0;
        }
        if (isPrim(n)) {
            return n - 1;
        }
        int[] divSumAndCount = divsSumAndCount(n);
        return divSumAndCount[0] - divSumAndCount[1];
    }

    //判断是否为质数
    public static boolean isPrim(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //将任意一个数拆解为质因数
    public static int[] divsSumAndCount(int n) {
        int Sum = 0;
        int Count = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                Sum += i;
                Count++;
                n /= i;
            }
        }
        return new int[]{Sum, Count};
    }
}
