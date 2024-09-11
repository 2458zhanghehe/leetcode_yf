package com.company.sort;

public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int Mid = L + (R - L) >> 1;
        return process(arr, L, Mid) + process(arr, Mid + 1, R) + merge(arr, L, Mid, R);
    }

    public static int merge(int[] arr, int L, int Mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = Mid + 1;
        int res = 0;
        while (p1 <= Mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= Mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= L) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < arr.length; i++) {
            arr[L + i] = help[i];
        }
        return res;
    }
}

