package com.company.trieTree;

import java.util.HashSet;

// leetcode 318 最大单词长度乘积
public class MaxProduct {
    //超时
    public static int maxProduct(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(notHaveSameChar(words[i],words[j])){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    private static boolean notHaveSameChar(String word1, String word2) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            if(set.contains(word2.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //利用位运算,一个int的低26位表示words[i]的a-z是否出现
    public static int maxProduct2(String[] words) {
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int x = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                x |= 1 << index;
            }
            nums[i] = x;
        }

        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((nums[i] & nums[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));
        System.out.println(maxProduct2(words));
    }

}
