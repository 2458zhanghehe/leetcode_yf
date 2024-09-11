package com.company.Graph;

//leetcode 200
public class NumIslands {
    public static int numIslands(char[][] grid) {
        int nums = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    infect(grid, i, j, nums++);
                }
            }
        }
        return nums - 1;
    }

    private static void infect(char[][] grid, int i, int j, int nums) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }

        grid[i][j] = (char)(nums + 49);
        infect(grid,i + 1, j, nums);
        infect(grid,i - 1, j, nums);
        infect(grid, i, j - 1, nums);
        infect(grid, i, j + 1, nums);
    }


    public static void main(String[] args) {
        char[][] chars = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int i = numIslands(chars);
        System.out.println(i);

        int a = 1;
        System.out.println((char)(a+49));

    }
}
