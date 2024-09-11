package com.company.practice.Dp_p;

public class CardsInLine_dp_p {
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

    public static int win3(int[] arr) {
        int[][] dp_f = new int[arr.length][arr.length];
        int[][] dp_s = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp_f[i][i] = arr[i];
        }
        for (int col = 1; col < arr.length; col++) {
            for (int i = col; i < arr.length; i++) {
                dp_f[i - col][i] = Math.max(arr[i - col] + dp_s[i - col + 1][i], arr[i] + dp_s[i - col][i - 1]);
                dp_s[i - col][i] = Math.min(dp_f[i - col + 1][i], dp_f[i - col][i - 1]);
            }
        }
        return Math.max(dp_f[0][arr.length - 1], dp_s[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 100, 10, 50};
        System.out.println(win1(arr));
        System.out.println(win3(arr));
    }
}
