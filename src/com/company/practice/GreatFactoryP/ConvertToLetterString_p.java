package com.company.practice.GreatFactoryP;

public class ConvertToLetterString_p {
    //数字串以字符串的形式给出  leetcode91
    public static int numDecodings1(String s) {
        char[] str = s.toCharArray();
        return process1(str, 0);
    }

    public static int process1(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int res = process1(str, index + 1);
        ;
        if (str[index] == '1' && (index + 1) < str.length - 1) {
            res += process1(str, index + 2);
        }
        if (str[index] == '2' && (index + 1) < str.length - 1 && str[index + 1] <= '6') {
            res += process1(str, index + 2);
        }
        return res;
    }

    public static int numDecodings2(String s) {
        char[] str = s.toCharArray();
        int[] dp = new int[str.length + 1];
        dp[str.length] = 1;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
            if (str[i] == '1' && (i + 1) < str.length - 1) {
                dp[i] += dp[i + 2];
            }
            if (str[i] == '2' && (i + 1) < str.length - 1 && str[i + 1] <= '6') {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "1111111";
        System.out.println(numDecodings1(s));
        System.out.println(numDecodings2(s));
    }
}
