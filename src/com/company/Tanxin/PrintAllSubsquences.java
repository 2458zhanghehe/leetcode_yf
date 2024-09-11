package com.company.Tanxin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PrintAllSubsquences {

    //打印子序列，从最初序列通过去除某些元素但不破坏元素的相对顺序
    //打印全排列 全部重组有多少种排列方式
    //打印子串   连续的，不能跳跃连接
    public static void printallss(String s) {
        char[] s_char = s.toCharArray();
        process(s_char, 0);
    }

    public static void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i + 1);  //要当前字符的路
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1);  //不要当前字符
        str[i] = tmp;
    }


    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, 0, ans, path);
        return ans;
    }

    //str固定不变   此时来到index位置，要或者不要 path为之前做出的选择
    public static void process1(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        //String no = path;
        process1(str, index + 1, ans, path);
        String yes = path + String.valueOf(str[index]);
        process1(str, index + 1, ans, yes);
    }


    public static List<String> subsNoRepeat(String s) {
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<>();    //hashset中不允许有重复值
        process2(str, 0, set, path);
        List<String> ans = new ArrayList<>();
        for (String cur : set) {
            ans.add(cur);
        }
        return ans;
    }

    public static void process2(char[] str, int index,
                                HashSet<String> set, String path) {
        if (index == str.length) {
            set.add(path);
            return;
        }
        String no = path;
        process2(str, index + 1, set, no);
        String yes = path + String.valueOf(str[index]);
        process2(str, index + 1, set, yes);

    }


    public static void main(String[] args) {
        String test = "aab";
        List<String> ans1 = subs(test);

        List<String> ans2 = subsNoRepeat(test);

        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("===================================");

        for (String str : ans2) {
            System.out.println(str);
        }

//        HashSet<Integer> set = new HashSet<>();   //HashSet没有弹出方法poll(),
//        set.add(1);                               //有add,remove,clear(全部清除),
//        set.add(1);                               //size,contains方法 遍历用for-each迭代
//        System.out.println(set);

        HashSet<String> set = new HashSet<>();   //HashSet没有弹出方法poll(),
        set.add("a");                               //有add,remove,clear(全部清除),
        set.add("" + "a");                               //size,contains方法 遍历用for-each迭代
        System.out.println(set);

    }
}
