package com.company.slidingW;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//leetcode30 非最优解，但注意生成全排列的方法
public class FindSubString {
    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        process(words, 0, list);
        List<Integer> ans = new ArrayList<>();
        for(String cur : list){
            int index = s.indexOf(cur);
            if(index >= 0){
                ans.add(index);
            }
        }
        ans = ans.stream().distinct().collect(Collectors.toList());
        return ans;
    }

    //获取数组的全排列，重要
    private static void process(String[] words, int i, ArrayList<String> list) {
        if(i == words.length){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words.length; j++){
                sb.append(words[j]);
            }
            list.add(sb.toString());
        }

        //每个都可以来到i位置做第一个
        for(int j = i; j < words.length; j++){
            swap(words,i,j);
            process(words, i + 1, list);
            swap(words,i,j);
        }
    }

    private static void swap(String[] words, int i, int j) {
        String tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
    }

    //对于全排列 + 包含问题，不需要考虑怎么排列，只有对应元素个数不超就可以
    public static List<Integer> findSubstring1(String s, String[] words){
        int wordCount = words.length;
        int wordLen = words[0].length();  ///题目限定words长度大于1
        List<Integer> ans = new ArrayList<>();

        //word cnt
        HashMap<String, Integer> map1 = new HashMap<>();
        for(String cur : words){
            Integer cnt = map1.getOrDefault(cur, 0);
            map1.put(cur, cnt + 1);
        }

        for (int i = 0; i < s.length() - wordCount * wordLen + 1; i++) {
            HashMap<String, Integer> map2 = new HashMap<>();
            int num = 0;
            while(num < wordCount){
                String cur = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if(map1.containsKey(cur)){
                    Integer cnt1 = map1.get(cur);
                    Integer cnt2 = map2.getOrDefault(cur, 0);
                    if(cnt1 >= cnt2 + 1){
                        map2.put(cur, cnt2 + 1);
                        num++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }
            if(num == wordCount){
                ans.add(i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        findSubstring(s,words);
    }
}
