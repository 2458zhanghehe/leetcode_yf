package com.company.recursionHuisu;

import com.company.linklist.RemoveNthFromEnd;

import javax.mail.search.IntegerComparisonTerm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode 77 组合
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        process(n,1, k, "", ans);
        return ans;
    }

    private static void process(int n, int index, int k, String str, List<List<Integer>> ans){
        if(index == n + 1){
            String[] split = Arrays.stream(str.split("_")).filter(s -> s.length() != 0).toArray(String[]::new);
            if(split.length == k){
                ArrayList<Integer> list = new ArrayList<>();
                for(String tmp : split){
                    Integer val = Integer.valueOf(tmp);
                    list.add(val);
                }
                ans.add(list);
            }
            return;
        }
        process(n,index + 1,k,str,ans);
        str += String.valueOf(index) + "_";
        process(n,index + 1, k, str, ans);
    }

    public static List<List<Integer>> combine1(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        process1(n,k, 1, list, ans);
        return ans;
    }

    private static void process1(int n, int k, int start, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == k){
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = start; j <= n; j++) {
            list.add(j);
            process1(n, k, j + 1, list, ans);
            // 错误1 list.remove(int j) 是remove(index)，如果想要remove(Object),list.remove(Integer.valueOf(j))
            // 但是这样会触发遍历
            //list.remove(Integer.valueOf(j));
            //list可以直接改为ArrayDeque
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        combine(1,1);
//        String str = "1_2_3_4_";
//        String regex = "_";
//        String[] split = str.split(regex);
//        System.out.println(split);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        ArrayList<Integer> list1 = new ArrayList<>(list);   //相当于赋值一个新的
        for(Integer tmp : list1){
            System.out.println(tmp);
        }

    }
}
