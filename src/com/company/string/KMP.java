package com.company.string;

//leetcode 28
public class KMP {
    // O(N)
    public static int kmp(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] s1_char = s1.toCharArray();
        char[] s2_char = s2.toCharArray();
        int[] next = getnext(s2_char);
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1_char.length && i2 < s2_char.length) {
            if (s1_char[i1] == s2_char[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) { //i2 == 0
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == s2_char.length ? i1 - i2 : -1;
    }


    public static int[] getnext(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] ans = new int[str.length];
        ans[0] = -1;
        ans[1] = 0;
        int i = 2;
        int cn = 0;  //cn位置的字符和当前i-1位置比较
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
