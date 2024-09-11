package com.company.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//stream流对list去重
public class StreanDistinct {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(2);
        list.add(2);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list.toString());

        //去重加排序
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(2);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(2);
        list1 = list1.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list1.toString());
    }
}
