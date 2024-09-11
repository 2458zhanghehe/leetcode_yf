package com.company.trieTree;

// lcr 064 实现一个魔法字典  前缀树 + 深度优先遍历
class MagicDictionary {
    private TrieNode root;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary){
            TrieNode cur = root;
            cur.pass++;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(cur.nexts[index] == null){
                    cur.nexts[index] = new TrieNode();
                }
                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }
    }
    
    public boolean search(String searchWord) {
        return process(0, searchWord, root, false);
    }

    private boolean process(int index, String searchWord, TrieNode cur, boolean already) {
        if(index == searchWord.length()){
            return cur.end > 0 && already;
        }

        boolean ans = false;
        for (int i = 0; i < 26; i++) {
            if(cur.nexts[i] != null){
                if(searchWord.charAt(index) - 'a' == i){
                    ans = ans || process(index + 1, searchWord, cur.nexts[i], already);
                }else if(!already){
                    ans = ans || process(index + 1, searchWord, cur.nexts[i], true);
                }
            }
        }
        return ans;
    }

    class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.nexts = new TrieNode[26];
            pass = 0;
            end = 0;
        }
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] words = {"hello", "leetcode"};
        magicDictionary.buildDict(words);
        boolean isMagic = magicDictionary.search("hollo");
        System.out.println(isMagic);
    }
}