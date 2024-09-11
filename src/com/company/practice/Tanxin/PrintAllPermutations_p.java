package com.company.practice.Tanxin;

import java.util.LinkedList;
import java.util.List;


// leetcode 014
public class PrintAllPermutations_p {
    public static List<String> Permutation(String s) {
        List<String> list = new LinkedList<>();
        if (s == null || s.length() < 1) {
            return list;
        }
        char[] s_char = s.toCharArray();
        process1(s_char, 0, list);
        return list;
    }

    public static void process1(char[] str, int i, List<String> list) {
        if (i == str.length) {
            list.add(String.valueOf(str));
            return;
        }
        for (int j = i; j < str.length; j++) {
            swap(str, i, j);
            process1(str, i + 1, list);
            swap(str, i, j);
        }
    }


    public static List<String> PermutationNoRepeat(String s) {
        List<String> list = new LinkedList<>();
        if (s == null || s.length() < 1) {
            return list;
        }
        char[] s_char = s.toCharArray();
        process2(s_char, 0, list);
        return list;
    }

    public static void process2(char[] str, int i, List<String> list) {
        if (i == str.length) {
            list.add(String.valueOf(str));
            return;
        }
        boolean[] appear = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!appear[str[j] - 'a']) {

                swap(str, i, j);
                process2(str, i + 1, list);
                swap(str, i, j);
                appear[str[j] - 'a'] = true;

            }
        }
    }


    public static void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "aba";
        List<String> list = Permutation(s);
        for (String s_tmp : list) {
            System.out.println(s_tmp);
        }
        System.out.println("*********************");
        List<String> listNoR = PermutationNoRepeat(s);
        for (String s_tmp : listNoR) {
            System.out.println(s_tmp);
            System.out.println(s_tmp.indexOf("ab"));
        }


//        String a = "";
//        System.out.println(a.length());
    }
}
