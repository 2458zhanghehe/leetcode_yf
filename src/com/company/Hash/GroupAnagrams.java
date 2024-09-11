package com.company.Hash;

import java.util.*;

//leetcode49 字母异位词分组
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams1(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if(!map.containsKey(sorted)){
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted,list);
            }else {
                List<String> list2 = map.get(sorted);
                list2.add(strs[i]);
                map.put(sorted,list2);
            }
        }

        List<List<String>> lists = new ArrayList<>(map.values());
        return lists;
    }


    //并查集
    private static int[] fathers;
    public static List<List<String>> groupAnagrams2(String[] strs){
        fathers = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            fathers[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if(sameChar(strs[i], strs[j])){
                    union(i,j);
                }
            }
        }

        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int fi = findFather(i);
            List<String> list = map.getOrDefault(fi, new ArrayList<String>());
            list.add(strs[i]);
            map.put(fi, list);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }

    private static void union(int i, int j) {
        int fi = findFather(i);
        int fj = findFather(j);
        if(fi != fj){
            fathers[fi] = fj;
        }
    }

    private static int findFather(int i) {
        if(i != fathers[i]){
            fathers[i] = findFather(fathers[i]);
        }
        return fathers[i];
    }

    private static boolean sameChar(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
            count2[str2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams2(strs);
    }
}
