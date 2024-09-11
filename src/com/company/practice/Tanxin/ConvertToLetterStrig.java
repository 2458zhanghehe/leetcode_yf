package com.company.practice.Tanxin;

public class ConvertToLetterStrig {
    public static int CTS(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] s_char = s.toCharArray();
        return procrss(s_char, 0);
    }

    public static int procrss(char[] str, int i) {
        if (i == str.length - 1 || i == str.length) {
            return 1;
        }
        if (str[i] == 0) {
            return 0;
        }
        int res = 0;
        if (str[i] == '1' || (str[i] == '2' && str[i + 1] <= '6')) {
            res += procrss(str, i + 1) + procrss(str, i + 2);
        } else {
            res += procrss(str, i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "111";
        System.out.println(CTS(s));
    }
}
