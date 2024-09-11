package com.company.GreatFactoryProblem;

//leetcode 1139
public class Largest1BorderedSquare {
    public static int largest1BorderedSquare(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] right = new int[height][width];
        for (int i = 0; i < height; i++) {
            right[i][width - 1] = grid[i][width - 1];
            for (int j = width - 2; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    right[i][j] = 0;
                } else {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }
        int[][] down = new int[height][width];
        for (int j = 0; j < grid[0].length; j++) {
            down[height - 1][j] = grid[height - 1][j];
            for (int i = height - 2; i >= 0; i--) {
                if (grid[i][j] == 0) {
                    down[i][j] = 0;
                } else {
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
        int maxPointsNum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] != 0) {
                    for (int length = 1; length <= Math.min(height - i, width - j); length++) {
                        if (right[i][j] >= length && down[i][j] >= length
                                && right[i + length - 1][j] >= length && down[i][j + length - 1] >= length) {
                            maxPointsNum = Math.max(maxPointsNum, length * length);
                        }
                    }
                }
            }
        }
        return maxPointsNum;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] grid1 = {{1}, {0}, {0}};
        System.out.println(largest1BorderedSquare(grid));
    }
}
