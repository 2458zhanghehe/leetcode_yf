package com.company.GreatFactoryProblem;

public class Candy {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] s_char = s.toCharArray();
        char[] s2 = getDouble(s_char);
        int R = -1;
        int C = -1;
        int ansIndex = -1;
        int ansLong = 0;
        int[] next = new int[s2.length];
        for (int i = 0; i < s2.length; i++) {
            next[i] = R > i ? Math.min(R - i, next[2 * C - i]) : 1;
            while (next[i] + i < s2.length && i - next[i] >= 0) {
                if (s2[next[i] + i] == s2[i - next[i]]) {
                    next[i]++;
                } else {
                    break;
                }
            }
            if (next[i] + i > R) {
                R = next[i] + i;
                C = i;
            }
            if (next[i] > ansLong) {
                ansLong = next[i];
                ansIndex = i;
            }
        }
        int index = (ansIndex - 1) / 2;
        ansLong -= 1;
        int start = ((ansIndex & 1) == 0) ? (index - (ansLong / 2 - 1)) : (index - ansLong / 2);
        int end = ((ansIndex & 1) == 0) ? (index + (ansLong / 2 + 1)) : (index + (ansLong / 2 + 1));
        return s.substring(start, end);
    }

    public static char[] getDouble(char[] str) {
        char[] ans = new char[str.length * 2 + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ((i & 1) == 0) ? '#' : str[(i - 1) / 2];
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cccc";
        System.out.println(longestPalindrome(s));
    }
}
