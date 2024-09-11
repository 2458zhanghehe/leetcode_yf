package com.company.practice.Tanxin;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PrintAllSubsquences_p {
    public static List<String> SubSquence(String s) {
        List<String> list = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        char[] s_char = s.toCharArray();
        process(s_char, 0, list);
        return list;
    }

    public static void process(char[] str, int i, List<String> list) {
        if (i == str.length) {

            list.add(String.valueOf(str));
            return;
        }
        process(str, i + 1, list);
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1, list);
        str[i] = tmp;
    }

    public static List<String> SubSquenceNoRepeat(String s) {
        List<String> list = new LinkedList<>();
        if (s == null || s.length() == 0) {
            return list;
        }
        String path = "";
        HashSet<String> set = new HashSet<>();
        process2(s, 0, path, set);
        for (String tmp : set) {
            list.add(tmp);
        }
        return list;
    }

    public static void process2(String s, int i, String path, HashSet<String> set) {
        if (i == s.length()) {
            set.add(path);
            return;
        }
        process2(s, i + 1, path, set);
        path += s.charAt(i);
        process2(s, i + 1, path, set);
    }


    public static void main(String[] args) {
        String s = "aab";
        List<String> list1 = SubSquence(s);
        for (String s_tmp : list1) {
            System.out.println(s_tmp);
            if (s_tmp.equals("a")) {
                System.out.println("有a");
            }
        }
        System.out.println(list1.contains("a"));

//        System.out.println("*************************");
//        List<String> list2 = SubSquenceNoRepeat(s);
//        for(String s_tmp:list2){
//            System.out.println(s_tmp);
//            if(s_tmp.equals("a")){
//                System.out.println("有a");
//            }
//        }

    }
}
