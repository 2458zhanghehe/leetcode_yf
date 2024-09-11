package com.company.array;

// leetcode 926 将字符串翻转到单调递增
public class MinFlipsMonoIncr {
    public static int minFlipsMonoIncr(String s) {
        int sLen = s.length();
        int[] left1 = new int[sLen];
        int[] right0 = new int[sLen];


        for (int i = 1; i < sLen; i++) {
            left1[i] = s.charAt(i - 1) == '1' ? left1[i - 1] + 1 : left1[i - 1];
        }

        for (int i = sLen - 2; i >= 0; i--) {
            right0[i] = s.charAt(i + 1) == '0' ? right0[i + 1] + 1 : right0[i + 1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < sLen; i++) {
            ans = Math.min(ans, (left1[i] + right0[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(minFlipsMonoIncr(s));
    }
}
