package com.company.practice.Tanxin;

import java.util.Arrays;
import java.util.Comparator;

//如何拼接字符串得到最小字典序
//有效比较策略具有传递性
public class LowLexicography {
    public static class Mycompare implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    public static String lowlexicogra(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new Mycompare());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
