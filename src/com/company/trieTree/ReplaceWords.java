package com.company.trieTree;

import java.util.List;

//LCR 063 单词替换
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieTree root = new TrieTree();
        for(String str : dictionary){
            TrieTree cur = root;
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                if(cur.nexts[index] == null){
                    cur.nexts[index] = new TrieTree();
                }
                cur = cur.nexts[index];
            }
            cur.end++;
        }
        String[] splits = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length - 1; i++) {
            String wordRoot = getWordRoot(splits[i], root);
            sb.append(wordRoot + " ");
        }
        sb.append(getWordRoot(splits[splits.length - 1], root));
        return sb.toString();
    }

    private static String getWordRoot(String split, TrieTree root) {
        TrieTree cur = root;
        for (int i = 0; i < split.length(); i++) {
            int index = split.charAt(i) - 'a';
            if(cur.nexts[index] == null){
                return split;
            }
            cur = cur.nexts[index];
            if(cur.end > 0){
                return split.substring(0, i + 1);
            }
        }
        return split;
    }

    class TrieTree{
        public int end;
        public TrieTree[] nexts;

        public TrieTree() {
            end = 0;
            nexts = new TrieTree[26];
        }
    }
}
