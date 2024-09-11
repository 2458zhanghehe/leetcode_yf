package com.company.Tanxin;

import java.util.*;

public class LowestLexicography {
    public static class LexicoSort implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    public static String Lowlexicograph(String[] s) {
        if (s == null || s.length < 2) {
            return "";
        }
        Arrays.sort(s, new LexicoSort());
        String res = "";
        for (int i = 0; i < s.length; i++) {
            res += s[i];
        }
        return res;
    }

}
