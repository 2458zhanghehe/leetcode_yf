package com.company.practice.GreatFactoryP;

public class IsLand_p {
    public static int[] island(int[][] grid) {
        int nums = 0;
        int maxarea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    nums++;
                    maxarea = Math.max(infect(grid, i, j), maxarea);
                }
            }
        }
        return new int[]{nums, maxarea};
    }

    public static int infect(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + infect(grid, i - 1, j) + infect(grid, i + 1, j) + infect(grid, i, j - 1) + infect(grid, i, j + 1);

    }

    public static void main(String[] args) {
        int[][] a = {{0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}};
        int[] ans = island(a);
        System.out.println("nums : " + ans[0]);
        System.out.println("maxarea : " + ans[1]);
    }
}
