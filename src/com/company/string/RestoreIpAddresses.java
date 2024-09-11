package com.company.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// leetcode 93 复原IP地址
public class RestoreIpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> ansList = new ArrayList<>();
        ArrayDeque<String> deque = new ArrayDeque<>();
        process(s, 0, 0, deque, ansList);
        return ansList;
    }

    private static void process(String s, int i, int partNums, Deque<String> deque, List<String> ansList) {
        if(i >= s.length()){
            if(partNums == 4){
                ansList.add(String.join(".", deque));
            }
            return;
        }
        if(partNums >= 4){
            return;
        }
        if(s.charAt(i) == '0') {
            deque.addLast("0");
            process(s, i + 1, partNums + 1, deque, ansList);
            deque.removeLast();
        }else if(s.charAt(i) < '3'){
            for (int j = 0; j < 2 && (i + j + 1) <= s.length(); j++) {
                deque.add(s.substring(i, i + j + 1));
                process(s, i + j + 1,partNums + 1, deque, ansList);
                deque.removeLast();
            }
            //因为三位数时还不能超过255，单拎出来
            if(i + 3 <= s.length() && Integer.valueOf(s.substring(i, i + 3)) < 256){
                deque.add(s.substring(i, i + 3));
                process(s, i + 3,partNums + 1, deque, ansList);
                deque.removeLast();
            }
        }else {
            for (int j = 0; j < 2 && (i + j + 1) <= s.length(); j++) {
                deque.add(s.substring(i, i + j + 1));
                process(s, i + j + 1,partNums + 1, deque, ansList);
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        String str = "000256";
        List<String> list = restoreIpAddresses(str);
        System.out.println(list);

//        ArrayList<String> list = new ArrayList<>();
//        list.add("zhangsan");
//        list.add("lisi");
//        list.add("liuer");
//        String concat = String.join(".", list);   //字符串拼接
//        System.out.println(concat);
    }
}
