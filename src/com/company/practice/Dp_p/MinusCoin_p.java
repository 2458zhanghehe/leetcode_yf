package com.company.practice.Dp_p;

import java.util.Arrays;

public class MinusCoin_p {
    public static int minusCoin1(int[] arr, int target) {
        return process1(arr, 0, target);
    }

    public static int process1(int[] arr, int index, int res) {
        if (res == 0) {
            return 0;
        }
        if (index == arr.length || res < 0) {
            return -1;
        }
        int p1 = process1(arr, index + 1, res);
        int p2 = process1(arr, index + 1, res - arr[index]);
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            } else if (p2 == -1) {
                return p1;
            } else {
                return Math.min(p1, p2 + 1);
            }
        }
    }

    public static int minusCoin2(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -2);
        }
        return process2(arr, 0, target, dp);
    }

    public static int process2(int[] arr, int index, int res, int[][] dp) {
        if (res == 0) {
            dp[index][res] = 0;
            return dp[index][res];
        }
        if (res < 0) {
            return -1;
        }
        if (index == arr.length) {
            dp[index][res] = -1;
            return dp[index][res];
        }
        int p1 = process2(arr, index + 1, res, dp);
        int p2 = process2(arr, index + 1, res - arr[index], dp);
        if (p1 == -1 && p2 == -1) {
            dp[index][res] = -1;
        } else {
            if (p1 == -1) {
                dp[index][res] = p2 + 1;
            } else if (p2 == -1) {
                dp[index][res] = p1;
            } else {
                dp[index][res] = Math.min(p1, p2 + 1);
            }
        }
        return dp[index][res];
    }

    public static int minusCoin3(int[] arr, int target) {
        int[][] dp = new int[arr.length + 1][target + 1];
        for (int j = 1; j < dp[0].length; j++) {
            dp[arr.length][j] = -1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j < dp[0].length; j++) {
                int p1 = dp[i + 1][j];
                int p2 = j - arr[i] < 0 ? -1 : dp[i + 1][j - arr[i]];
                if (p1 == -1 && p2 == -1) {
                    dp[i][j] = -1;
                } else {
                    if (p1 == -1) {
                        dp[i][j] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[i][j] = p1;
                    } else {
                        dp[i][j] = Math.min(p1, p2 + 1);
                    }
                }
            }
        }
        return dp[0][target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 10};
        int target = 10;
        System.out.println(minusCoin1(arr, target));
        System.out.println(minusCoin2(arr, target));
        System.out.println(minusCoin3(arr, target));
    }
}
