package com.company.recursionHuisu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearch2 {
    //时间复杂度超一个
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ansList = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                ansList.add(word);
            }
        }
        return ansList;
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean flag = dfs(board, visited, i, j, words, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int i, int j, char[] words, int index) {
        if (index == words.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != words[index]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, visited, i + 1, j, words, index + 1) ||
                dfs(board, visited, i - 1, j, words, index + 1) ||
                dfs(board, visited, i, j + 1, words, index + 1) ||
                dfs(board, visited, i, j - 1, words, index + 1);
        visited[i][j] = false;
        return res;
    }


    private static TrieNode root = new TrieNode();
    public static List<String> findWords2(char[][] board, String[] words){
        if(board == null || board.length == 0 || board[0].length == 0){
            return new ArrayList<>();
        }


        for(String word : words){
            insert(root, word);
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs2(board, visited, i, j, root, set, rows, cols);
            }
        }
        List<String> list = new ArrayList<>();
        for(String word : set){
            list.add(word);
        }
        return list;

    }

    private static void dfs2(char[][] board, boolean[][] visited, int i, int j,
                             TrieNode curNode, HashSet<String> set, int rows, int cols) {


        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || curNode.nexts[board[i][j] - 'a'] == null){
            return;
        }

        TrieNode nextNode = curNode.nexts[board[i][j] - 'a'];

        if(nextNode.end == 1){
            set.add(nextNode.word);
            if(nextNode.pass == 1){
                return;
            }
        }

        visited[i][j] = true;
        dfs2(board, visited, i + 1, j, nextNode, set, rows, cols);
        dfs2(board, visited, i - 1, j, nextNode, set, rows, cols);
        dfs2(board, visited, i, j - 1, nextNode, set, rows, cols);
        dfs2(board, visited, i, j + 1, nextNode, set, rows, cols);
        visited[i][j] = false;
    }

    private static void insert(TrieNode root, String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char curChar = word.charAt(i);
            if(curNode.nexts[curChar - 'a'] == null){
                curNode.nexts[curChar - 'a'] = new TrieNode();
            }
            curNode.nexts[curChar - 'a'].pass++;
            curNode = curNode.nexts[curChar - 'a'];
        }
        curNode.end++;
        curNode.word = word;
    }

    static class TrieNode{
        public String word;
        public int pass;
        public int end;
        TrieNode[] nexts;

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }


    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String[] words = {"ab"};
        List<String> list = findWords2(board, words);
        System.out.println(list);
    }

}
