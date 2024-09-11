package com.company.practice.GreatFactoryP;

import com.company.BNtree.HeapInsertAndHeapify;

import java.util.Arrays;
import java.util.HashSet;

public class MagicOp_p {
    public static int magicOp(int[] arr1, int[] arr2) {
        double sum1 = (double) Arrays.stream(arr1).sum();
        double sum2 = (double) Arrays.stream(arr2).sum();
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] moreArr;
        int[] lessArr;
        double moreSum;
        double lessSum;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {  //重定位
            moreArr = arr1;
            moreSum = sum1;
            lessArr = arr2;
            lessSum = sum2;
        } else {
            moreArr = arr2;
            moreSum = sum2;
            lessArr = arr1;
            lessSum = sum1;
        }
        Arrays.sort(moreArr);
        HashSet<Integer> set = new HashSet<>();
        for (Integer tmp : lessArr) {
            set.add(tmp);
        }
        int moreSize = moreArr.length;
        int lessSize = lessArr.length;
        int ops = 0;
        for (int i = 0; i < moreArr.length; i++) {
            double cur = (double) moreArr[i];
            if (cur < avg(moreSum, moreSize) &&
                    cur > avg(lessSum, lessSize) &&
                    !set.contains(moreArr[i])) {
                moreSum -= cur;
                moreSize--;
                lessSum += cur;
                lessSize++;
                set.add(moreArr[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int size) {
        return sum / (double) size;
    }
}
