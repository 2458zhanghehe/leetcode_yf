package com.company.Tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode 763. 划分字母区间
public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            //如果只出现一次，就首尾位置都是i+1
            if(index[c][0] == 0){
                index[c][0] = i + 1;
            }
            index[c][1] = i + 1;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if(index[c][0] == i + 1){
                int j = i + 1;
                int right = index[c][1] - 1;
                while(j < s.length() && j <= right){
                    int c2 = s.charAt(j) - 'a';
                    if(index[c2][1] > right){
                        right = index[c2][1] - 1;
                    }
                    j++;
                }
                ans.add(right - i + 1);
                i = right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);
    }
}
