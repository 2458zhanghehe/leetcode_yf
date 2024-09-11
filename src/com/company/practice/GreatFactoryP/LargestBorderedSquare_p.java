package com.company.practice.GreatFactoryP;

public class LargestBorderedSquare_p {
    public static int largest1BorderedSquare_p(int[][] grid) {
        int H = grid.length;
        int W = grid[0].length;
        int nums = 0;
        int[][] right = new int[H][W];
        for (int i = 0; i < H; i++) {
            right[i][W - 1] = grid[i][W - 1];
            for (int j = W - 2; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    right[i][j] = 0;
                } else {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }
        int[][] down = new int[H][W];
        for (int j = 0; j < W; j++) {
            down[H - 1][j] = grid[H - 1][j];
            for (int i = H - 2; i >= 0; i--) {
                if (grid[i][j] == 0) {
                    down[i][j] = 0;
                } else {
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int len = 1; len < Math.min(H - i, W - j); len++) {
                    if (right[i][j] >= len && right[i + len - 1][j] >= len
                            && down[i][j] >= len && down[i][j + len - 1] >= len) {
                        nums = Math.max(nums, len * len);
                    }
                }
            }
        }
        return nums;
    }
}
