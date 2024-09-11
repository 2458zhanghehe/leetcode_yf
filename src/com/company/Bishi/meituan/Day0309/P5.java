package com.company.Bishi.meituan.Day0309;

import java.util.HashSet;

public class P5 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();

        //求两个集合交集
        set1.retainAll(set);
    }
}
