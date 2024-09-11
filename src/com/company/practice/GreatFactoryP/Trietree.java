package com.company.practice.GreatFactoryP;

public class Trietree {
    public static class TrieNode {
        public int pass = 0;
        public int end = 0;
        public TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode cur = root;
            root.pass++;
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (cur.nexts[index] == null) {
                    cur.nexts[index] = new TrieNode();
                }
                cur = cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        public void delete(String word) {
            if (search(word) == 0) {
                return;
            }
            int index = 0;
            TrieNode cur = root;
            root.pass--;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (--cur.nexts[index].pass == 0) {
                    cur.nexts[index] = null;
                    return;
                }
                cur = cur.nexts[index];
            }
            cur.end--;
        }

        public int search(String word) {
            if (word == null || word.length() == 0) {
                return 0;
            }
            TrieNode cur = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (cur.nexts[index] == null) {
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.end;
        }

        public int preword(String word) {
            if (word == null || word.length() == 0) {
                return 0;
            }
            TrieNode cur = root;
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                if (cur.nexts[index] == null) {
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.pass;
        }

    }

}
