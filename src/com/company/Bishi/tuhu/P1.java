package com.company.Bishi.tuhu;

public class P1 {
    public static int maxPriceValue (int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int j = 0; j < dp.length; j++) {
            if(grid[0][j] == -1 || (j > 0 && dp[j - 1] == -1)){
                dp[j] = -1;
            }else {
                dp[j] = (j > 0 ? dp[j - 1] : 0) + grid[0][j];
            }
        }
        for(int i = 1; i < grid.length; i++){
            if(grid[i][0] == -1 || dp[0] == -1){
                dp[0] = -1;
            }else {
                dp[0] += grid[i][0];
            }
            for (int j = 1; j < grid[0].length; j++) {
                if(grid[i][j] == -1){
                    dp[j] = -1;
                }else {
                    dp[j] = grid[i][j] + Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxPriceValue(grid));
    }

}
