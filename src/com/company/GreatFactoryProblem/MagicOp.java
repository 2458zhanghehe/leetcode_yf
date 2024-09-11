package com.company.GreatFactoryProblem;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.HashSet;

//左93
public class MagicOp {
    //arr1和arr2均不重复且不空
    public static int magicOp(int[] arr1, int[] arr2) {
        double sum1 = (double) (Arrays.stream(arr1).sum());
        double sum2 = (double) (Arrays.stream(arr2).sum());
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] moreArr = null;
        int[] lessArr = null;
        double moreSum;
        double lessSum;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            moreArr = arr1;
            lessArr = arr2;
            moreSum = sum1;
            lessSum = sum2;
        } else {
            moreArr = arr2;
            lessArr = arr1;
            moreSum = sum2;
            lessSum = sum1;
        }
        Arrays.sort(moreArr);
        HashSet<Integer> set = new HashSet<>();
        for (Integer tmp : lessArr) {
            set.add(tmp);
        }
        int ops = 0;
        int moreSize = moreArr.length;
        int lessSize = lessArr.length;
        for (int i = 0; i < moreArr.length; i++) {
            double cur = (double) moreArr[i];
            if (cur > avg(lessSum, lessSize) &&
                    cur < avg(moreSum, moreSize) &&
                    !set.contains(moreArr[i])) {
                moreSize--;
                lessSize++;
                moreSum -= cur;
                lessSum += cur;
                set.add(moreArr[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int length) {
        return sum / ((double) length);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 19, 2, 18, 3, 17, 6, 14, 5, 15, 7, 13, 8, 12, 9, 11};
        int[] arr2 = {5, 3, 8};
        System.out.println(magicOp(arr1, arr2));
    }
}
