package com.company.Dp;

import java.util.Arrays;

public class CardsInLine_dp {
    public static int win1(int[] arr) {
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public static int f(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L + 1, R), arr[R] + s(arr, L, R - 1));
    }

    public static int s(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        return Math.min(f(arr, L + 1, R), f(arr, L, R - 1));
    }

    public static int win2(int[] arr) {
        int[][] dp_f = new int[arr.length][arr.length];
        int[][] dp_s = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp_f[i], -1);
            Arrays.fill(dp_s[i], -1);
        }
        return Math.max(f1(arr, 0, arr.length - 1, dp_f, dp_s), s1(arr, 0, arr.length - 1, dp_f, dp_s));
    }

    public static int f1(int[] arr, int L, int R, int[][] dp_f, int[][] dp_s) {
        if (dp_f[L][R] != -1) {
            return dp_f[L][R];
        }
        if (L == R) {
            dp_f[L][R] = arr[L];
            return dp_f[L][R];
        }
        dp_f[L][R] = Math.max(arr[L] + s1(arr, L + 1, R, dp_f, dp_s), arr[R] + s1(arr, L, R - 1, dp_f, dp_s));
        return dp_f[L][R];
    }

    public static int s1(int[] arr, int L, int R, int[][] dp_f, int[][] dp_s) {
        if (dp_s[L][R] != -1) {
            return dp_s[L][R];
        }
        if (L == R) {
            dp_s[L][R] = 0;
            return dp_s[L][R];
        }
        dp_s[L][R] = Math.min(f1(arr, L + 1, R, dp_f, dp_s), f1(arr, L, R - 1, dp_f, dp_s));
        return dp_s[L][R];
    }

    public static int win3(int[] arr) {
        int[][] dp_f = new int[arr.length][arr.length];
        int[][] dp_s = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp_f[i][i] = arr[i];
            dp_s[i][i] = 0;
        }
        int col = 1;
        while (col < arr.length) {
            for (int i = col; i < arr.length; i++) {
                dp_f[i - col][i] = Math.max(arr[i - col] + dp_s[i - col + 1][i], arr[i] + dp_s[i - col][i - 1]);
                dp_s[i - col][i] = Math.min(dp_f[i - col + 1][i], dp_f[i - col][i - 1]);
            }
            col++;
        }
        return Math.max(dp_f[0][arr.length - 1], dp_s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 100, 2, 50};
        System.out.println(win1(arr));
        System.out.println(win2(arr));
        System.out.println(win3(arr));
    }
}
