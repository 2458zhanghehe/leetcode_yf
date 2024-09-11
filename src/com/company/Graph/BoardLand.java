package com.company.Graph;

//leetcode130
public class BoardLand {
    public static void solve(char[][] board) {
        if(board.length <= 2 || board[0].length <= 2){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        short[][] flag = new short[m][n];
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                infect(board,0, i, flag);
            }
            if(board[m - 1][i] == 'O'){
                infect(board,m - 1, i, flag);
            }
        }
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                infect(board,i,0,flag);
            }
            if(board[i][n - 1] == 'O'){
                infect(board, i,n - 1,flag);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != 'X' && flag[i][j] != 1){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static void infect(char[][] board, int i, int j, short[][] flag) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O' || flag[i][j] == 1){
            return;
        }
        flag[i][j] = 1;
        infect(board,i + 1, j, flag);
        infect(board,i - 1, j, flag);
        infect(board, i, j + 1, flag);
        infect(board, i, j - 1, flag);
    }

    public static void main(String[] args) {
        char[][] ss = {{'x','x','x','x'},{'x','O','O','x'},{'x','x','O','x'},{'x','O','x','x'}};
        solve(ss);
    }
}
