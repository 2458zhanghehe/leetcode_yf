package com.company.GreatFactoryProblem;

public class SudokuSolver {
    public static char[][] sudokuSolver(char[][] board) {
        boolean[][] raw = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] bin = new boolean[9][9];
        init_biao(board, raw, col, bin);
        process(board, raw, col, bin, 0, 0);
        return board;
    }

    public static void init_biao(char[][] borad, boolean[][] raw, boolean[][] col, boolean[][] bin) {
        for (int i = 0; i < borad.length; i++) {
            for (int j = 0; j < borad.length; j++) {
                int binI = 3 * (i / 3) + j / 3;
                if (borad[i][j] != '.') {
                    int num = borad[i][j] - '0';
                    raw[i][num] = true;
                    col[j][num] = true;
                    bin[binI][num] = true;
                }
            }
        }
    }

    public static boolean process(char[][] board, boolean[][] raw, boolean[][] col, boolean[][] bin, int i, int j) {
        if (i == 9) {
            return true;
        }
        int nextI = j == 8 ? i + 1 : i;
        int nextJ = j == 8 ? 0 : j + 1;
        if (board[i][j] != '.') {
            return process(board, raw, col, bin, nextI, nextJ);
        } else {
            int binI = 3 * (i / 3) + (j / 3);
            for (int num = 0; num < 10; num++) {
                if ((!raw[i][num]) && (!col[j][num]) && (!bin[binI][num])) {
                    board[i][j] = (char) (num + '0');
                    raw[i][num] = true;
                    col[j][num] = true;
                    bin[binI][num] = true;
                    if (process(board, raw, col, bin, nextI, nextJ)) {
                        return true;
                    }
                    board[i][j] = '.';
                    raw[i][num] = false;
                    col[j][num] = false;
                    bin[binI][num] = false;
                }
            }
            return false;
        }
    }
}
