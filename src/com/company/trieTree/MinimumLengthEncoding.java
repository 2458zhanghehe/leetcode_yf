package com.company.trieTree;


import java.util.Arrays;
import java.util.Comparator;

// lcr 065 单词的压缩编码
public class MinimumLengthEncoding {
    public int minimumLengthEncoding1(String[] words) {
        //方案1：让长的先建立
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        TrieNode root = new TrieNode();
        int len = 0;
        for(String word : words){
            TrieNode cur = root;
            boolean needAdd = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if(cur.nexts[index] == null){
                    needAdd = true;
                    cur.nexts[index] = new TrieNode();
                }
                cur = cur.nexts[index];
            }
            if(needAdd){
                len += word.length() + 1;
            }
        }
        return len;
    }

    public int minimumLengthEncoding2(String[] words) {
        TrieNode root = new TrieNode();
        int len = 0;
        for(String word : words){
            TrieNode cur = root;
            boolean needAdd = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if(cur.nexts[index] == null){
                    needAdd = true;
                    cur.nexts[index] = new TrieNode();
                }
                cur = cur.nexts[index];
                //方案二：添加end标识
                if(cur.end > 0 && i != 0){
                    // 1是因为#
                    len -= word.length() - i + 1;
                    cur.end = 0;
                }
            }
            if(needAdd){
                len += word.length() + 1;
                cur.end++;
            }
        }
        return len;
    }


    class TrieNode{
        public int end;
        TrieNode[] nexts;


        public TrieNode() {
            this.nexts = new TrieNode[26];
            end = 0;
        }
    }


    public static void main(String[] args) {
        String[] strs = {"atime","time","btime"};
        MinimumLengthEncoding minimumLengthEncoding = new MinimumLengthEncoding();
        System.out.println(minimumLengthEncoding.minimumLengthEncoding2(strs));
    }
}
