package com.company.matrix;

//leetcode289生命游戏
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] ans = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int cur = getValue(board,i,j);
                if(cur < 2){
                    ans[i][j] = 0;
                }else if(cur > 3){
                    ans[i][j] = 0;
                }else if(cur == 2){
                    ans[i][j] = board[i][j];
                }else {
                    ans[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = ans[i][j];
            }
        }
    }

    private int getValue(int[][] board, int i, int j) {
        return f(board, i - 1, j - 1) + f(board, i - 1, j) + f(board, i - 1, j + 1) +
                f(board, i, j - 1) + f(board, i, j + 1) +
                f(board, i + 1, j - 1) + f(board, i + 1, j) + f(board, i+  1, j + 1);
    }

    //重要，再拆分，1直接在getValue中判断会很复杂
    private int f(int[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return 0;
        }
        return board[x][y];
    }

    //原地操作   原活->死 2    原死->活 -1
    public void gameOfLife2(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int cur = getValue2(board,i,j);
                if(cur < 2){
                    board[i][j] = (board[i][j] == 1) ? 2 : 0;
                }else if(cur > 3){
                    board[i][j] = (board[i][j] == 1) ? 2 : 0;
                }else if(cur == 3){
                    board[i][j] = (board[i][j] == 0) ? -1 : 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getValue2(int[][] board, int i, int j) {
        return f2(board, i - 1, j - 1) + f2(board, i - 1, j) + f2(board, i - 1, j + 1) +
                f2(board, i, j - 1) + f2(board, i, j + 1) +
                f2(board, i + 1, j - 1) + f2(board, i + 1, j) + f2(board, i+  1, j + 1);
    }

    //重要，再拆分，1直接在getValue中判断会很复杂
    private int f2(int[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return 0;
        }
        return board[x][y] <= 0 ? 0 : 1;
    }

    //利用第二位的信息，下一状态保存在第二位，第一步不动
    public void gameOfLife3(int[][] board){
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int cur = getValue3(board,i,j);
                if(cur == 3 || (cur == 2 && board[i][j] == 1)){
                    board[i][j] |= 2;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] >>= 1;
            }
        }


    }

    private int getValue3(int[][] board, int i, int j) {
        return f3(board, i - 1, j - 1) + f3(board, i - 1, j) + f3(board, i - 1, j + 1) +
                f3(board, i, j - 1) + f3(board, i, j + 1) +
                f3(board, i + 1, j - 1) + f3(board, i + 1, j) + f3(board, i+  1, j + 1);
    }

    private int f3(int[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return 0;
        }
        return (board[x][y] & 1);
    }
}
