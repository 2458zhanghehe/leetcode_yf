package com.company.practice.GreatFactoryP;

public class KMP_p {
    public static int kmpp(String s1, String s2) {
        if (s1 == null || s1.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] s1_char = s1.toCharArray();
        char[] s2_char = s2.toCharArray();
        int[] next = getnext(s2_char);
        int i = 0;
        int j = 0;
        while (i < s1_char.length && j < s2_char.length) {
            if (s1_char[i] == s2_char[j]) {
                i++;
                j++;
            } else if (j > 0) {
                j = next[j];
            } else {
                i++;
            }
        }
        return j == s2_char.length ? i - j : -1;
    }

    public static int[] getnext(char[] str) {
        int[] ans = new int[str.length];
        ans[0] = -1;
        ans[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < str.length) {
            if (str[i - 1] == str[cn]) {
                ans[i++] = ++cn;
            } else if (cn > 0) {
                cn = ans[cn];
            } else {
                ans[i++] = 0;
            }
        }
        return ans;
    }

}
