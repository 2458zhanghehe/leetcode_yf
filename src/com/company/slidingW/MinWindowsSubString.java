package com.company.slidingW;


//左36  leetcode76
public class MinWindowsSubString {
    public static String mws(String s, String target) {
        if (s.length() < target.length()) {
            return "";
        }
        char[] s_char = s.toCharArray();
        char[] t_char = target.toCharArray();
        int[] cnt = new int[256];
        for (char tmp : t_char) {
            cnt[tmp]--;
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int L = 0, R = 0, debts = t_char.length; R < s_char.length; R++) {
            if (cnt[s_char[R]]++ < 0) {
                debts--;
            }
            if (debts == 0) {
                while (cnt[s_char[L]] > 0) {
                    cnt[s_char[L++]]--;
                }
                if (R - L + 1 < len) {
                    len = R - L + 1;
                    start = L;
                }
            }
        }
        return len != Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }
}
