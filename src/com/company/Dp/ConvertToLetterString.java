package com.company.Dp;

public class ConvertToLetterString {

    //数字串以字符串的形式给出  leetcode 91  解码方法
    public static int convertToLetterString1(String s) {
        char[] s_char = s.toCharArray();
        return process1(s_char, 0);
    }

    public static int process1(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int res = process1(str, index + 1);
        if (str[index] == '1') {
            res += (index + 2) <= str.length ? process1(str, index + 2) : 0;
        }
        if (str[index] == '2' && (index + 1) < str.length && str[index + 1] <= '6') {
            res += process1(str, index + 2);
        }
        return res;
    }

    public static int convertToLetterString3(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[str.length + 1];
        dp[str.length] = 1;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (str[i] == '1') {
                    dp[i] += ((i + 2) <= str.length ? dp[i + 2] : 0);
                }
                if (str[i] == '2' && (i + 1) < str.length && str[i + 1] <= '6') {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        System.out.println(convertToLetterString1("106"));
        System.out.println(convertToLetterString3("111111"));

    }
}
