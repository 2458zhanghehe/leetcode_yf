package com.company.practice.GreatFactoryP;

import com.company.linklist.FindFirstIntersectNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.management.MalformedObjectNameException;
import java.time.LocalDate;
import java.util.*;

public class LongestSubArrMultiPositive {

    public static int LongLong(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int maxLong = 0;
        int start = 0;
        int counts = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int[] arri = Arrays.copyOfRange(arr, start, i);
                maxLong = Math.max(maxLong, LongZheng(arri));
                start = i + 1;
                counts++;
            }
        }
        if (counts == 0) {
            maxLong = LongZheng(arr);
        }
        return maxLong;
    }

    public static int LongZheng(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int counts = 0;
        int MostL = arr.length;
        int MostR = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                counts++;
                if (counts == 1) {
                    MostL = i;
                }
                MostR = i;
            }
        }
        if ((counts & 1) == 0) {
            return arr.length;
        }
        return Math.max(arr.length - MostL - 1, MostR);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, -1, 4};
        System.out.println(LongLong(arr));
    }
}
