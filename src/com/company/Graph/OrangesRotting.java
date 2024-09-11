package com.company.Graph;

//leetcode 994 腐烂的橘子
public class OrangesRotting {
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minute = 0;
        boolean existGood;
        while(true){
            boolean isContinue = true;
            existGood = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] - minute == 2){
                        grid[i][j] = -1;
                        if(i + 1 < m && grid[i + 1][j] == 1){
                            grid[i + 1][j] = 2 + minute + 1;
                            isContinue = false;
                        }
                        if(i - 1 >= 0 && grid[i - 1][j] == 1){
                            grid[i - 1][j] = 2 + minute + 1;
                            isContinue = false;
                        }
                        if(j + 1 < n && grid[i][j + 1] == 1){
                            grid[i][j + 1] = 2 + minute + 1;
                            isContinue = false;
                        }
                        if(j - 1 >= 0 && grid[i][j - 1] == 1){
                            grid[i][j - 1] = 2 + minute + 1;
                            isContinue = false;
                        }
                    }else if(grid[i][j] == 1){
                        existGood = true;
                    }
                }
            }
            if(isContinue){
                break;
            }else {
                minute++;
            }
        }
        return existGood ? -1 : minute;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        orangesRotting(grid);
    }
}
