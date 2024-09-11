package com.company.practice.GreatFactoryP;

public class Manacher_p {
    public static int manacher(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] s_char = s.toCharArray();
        char[] s_charTwo = getDouble(s_char);
        int[] pre = new int[s_charTwo.length];
        int R = -1;
        int C = -1;
        int longest = 0;
        for (int i = 0; i < pre.length; i++) {
            pre[i] = R > i ? Math.min(R - i, pre[2 * C - i]) : 1;
            while (pre[i] + i < s_charTwo.length && i - pre[i] > -1) {
                if (s_charTwo[pre[i] + i] == s_charTwo[i - pre[i]]) {
                    pre[i]++;
                } else {
                    break;
                }
            }
            if (pre[i] + i > R) {
                C = i;
                R = pre[i] + i;
            }
            longest = Math.max(longest, pre[i]);
        }
        return longest - 1;
    }

    public static char[] getDouble(char[] str) {
        char[] ans = new char[2 * str.length + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (i & 1) == 0 ? '#' : str[(i - 1) / 2];
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "asdaslj12321dskjfldj";
        System.out.println(manacher(s));
    }
}
