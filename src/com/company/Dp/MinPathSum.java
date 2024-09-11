package com.company.Dp;

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int ans = process(grid,0,0, grid.length, grid[0].length);
        return ans;
    }

    private static int process(int[][] grid, int i, int j, int m, int n) {
        if(i == m - 1 && j == n - 1){
            return grid[i][j];
        }
        //向下走
        int p1 = Integer.MAX_VALUE;
        if(i < m - 1){
            p1 = process(grid, i + 1, j, m, n);
        }
        //向右走
        int p2 = Integer.MAX_VALUE;
        if(j < n - 1){
            p2 = process(grid, i, j + 1, m ,n);
        }
        return Math.min(p1,p2) + grid[i][j];
    }


    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int cur = Integer.MAX_VALUE;
                if(i < m - 1){
                    cur = dp[i + 1][j];
                }
                if(j < n - 1){
                    cur = Math.min(cur, dp[i][j + 1]);
                }
                dp[i][j] = cur + grid[i][j];
            }
        }
        return dp[0][0];
    }



    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}};
        int ans = minPathSum2(grid);
    }
}
