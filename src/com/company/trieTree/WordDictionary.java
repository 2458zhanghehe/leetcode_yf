package com.company.trieTree;


//leetcode211 添加与搜索单词-数据结构设计
class WordDictionary {
    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;
        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if(word == null){
            return;
        }
        TrieNode cur = root;
        cur.pass++;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(cur.nexts[index] == null){
                cur.nexts[index] = new TrieNode();
            }
            cur.nexts[index].pass++;
            cur = cur.nexts[index];
        }
        cur.end++;
    }

    public boolean search(String word) {
        return process(word,0,root);
    }

    private boolean process(String word, int i, TrieNode cur) {
        if(i == word.length() - 1){
            if(word.charAt(i) == '.'){
                for(int j = 0; j < 26; j++){
                    if(cur.nexts[j] != null && cur.nexts[j].end > 0){
                        return true;
                    }
                }
                return false;
            }else {
                int index = word.charAt(i) - 'a';
                if(cur.nexts[index] != null){
                    return cur.nexts[index].end > 0;
                }
                return false;
            }

        }

        if(word.charAt(i) == '.'){
            for(int j = 0; j < 26; j++){
                if(cur.nexts[j] != null){
                    boolean curAns = process(word, i + 1, cur.nexts[j]);
                    if(curAns){
                        return true;
                    }
                }
            }
            return false;
        }else {
            int index = word.charAt(i) - 'a';
            if(cur.nexts[index] == null){
                return false;
            }else {
                return process(word,i + 1,cur.nexts[index]);
            }
        }
    }

//    public static void main(String[] args) {
//        WordDictionary dic = new WordDictionary();
//        dic.addWord("bad");
//        dic.addWord("dad");
//        dic.addWord("mad");
//        dic.search("pad");
//        dic.search("bad");
//        dic.search(".ad");
//        dic.search("b..");
//    }
}