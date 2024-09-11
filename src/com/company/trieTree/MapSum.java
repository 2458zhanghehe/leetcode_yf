package com.company.trieTree;

import java.util.HashMap;

//  lcr 066 键值映射
class MapSum {

    private TrieNode root;
    private HashMap<String, Integer> map;

    public MapSum() {
        root = new TrieNode(0);
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {

        Integer preVal = map.getOrDefault(key, 0);
        map.put(key, val);
        val = val - preVal;

        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(cur.nexts[index] == null){
                cur.nexts[index] = new TrieNode(val);
            }else {
                cur.nexts[index].val += val;
            }
            cur = cur.nexts[index];
        }
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(cur.nexts[index] == null){
                return 0;
            }
            cur = cur.nexts[index];
        }
        return cur.val;
    }


    class TrieNode{
        public int val;
        public TrieNode[] nexts;

        public TrieNode(int val) {
            this.val = val;
            nexts = new TrieNode[26];
        }
    }
}