package com.company.recursionHuisu;

//leetcode79 单词搜索
public class WorldSearch {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] already = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    already[i][j] = true;
                    boolean exist = process(board, word,0, i, j, already);
                    already[i][j] = false;
                    if(exist){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean process(char[][] board, String word ,int index, int i, int j, boolean[][] already) {
        if(index == word.length() - 1){
            return true;
        }
        boolean ans1 = false;
        if(i + 1 < board.length && board[i + 1][j] == word.charAt(index + 1) && !already[i + 1][j]){
            already[i + 1][j] = true;
            ans1 = process(board, word, index + 1, i + 1, j, already);
            already[i + 1][j] = false;
        }
        boolean ans2 = false;
        if(i - 1 >= 0 && board[i - 1][j] == word.charAt(index + 1) && !already[i - 1][j]){
            already[i - 1][j] = true;
            ans2 = process(board,word,index + 1, i - 1, j, already);
            already[i - 1][j] = false;
        }
        boolean ans3 = false;
        if(j + 1 < board[0].length && board[i][j + 1] == word.charAt(index + 1) && !already[i][j + 1]){
            already[i][j + 1] = true;
            ans3 = process(board,word,index + 1, i, j + 1, already);
            already[i][j + 1] = false;
        }
        boolean ans4 = false;
        if(j - 1 >= 0 && board[i][j - 1] == word.charAt(index + 1) && !already[i][j - 1]){
            already[i][j - 1] = true;
            ans4 = process(board,word,index + 1, i, j - 1, already);
            already[i][j - 1] = false;
        }

        return ans1 || ans2 || ans3 || ans4;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},
                            {'S','F','E','S'},
                            {'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }
}
