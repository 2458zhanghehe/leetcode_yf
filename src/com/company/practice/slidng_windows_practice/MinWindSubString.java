package com.company.practice.slidng_windows_practice;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class MinWindSubString {
    public static String MSS(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        int[] cnts = new int[256];
        for (char c : t_char) {
            cnts[c]--;
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for (int R = 0, L = 0, total_d = t_char.length; R < s_char.length; R++) {
            if (cnts[s_char[R]]++ < 0) {
                total_d--;
            }
            if (total_d == 0) {
                while (cnts[s_char[L]] > 0) {
                    cnts[s_char[L++]]--;
                }
                if (R - L + 1 < len) {
                    start = L;
                    len = R - L + 1;
                }
            }
        }
        return len != Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }

    public static void main(String[] args) {
        String s = "ae";
        String t = "a";
        String ans = MSS(s, t);
        System.out.print(ans);
    }
}
