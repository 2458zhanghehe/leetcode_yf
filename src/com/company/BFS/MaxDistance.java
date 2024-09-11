package com.company.BFS;

import java.util.Arrays;

// 1162 地图分析   左程云算法讲解062 第一题
public class MaxDistance {

    //超时
    public static int maxDistance(int[][] grid) {
        int ans = -1;
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] memory = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memory[i], - 2);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0){
                    int curAns = bfs(grid, i, j, visited, memory);
                    memory[i][j] = curAns;
                    if(curAns == -1){
                        return -1;
                    }
                    ans = Math.max(ans, curAns);
                }
            }
        }
        return ans;
    }

    private static int bfs(int[][] grid, int i, int j, boolean[][] visited, int[][] memory) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid.length || visited[i][j]){
            return -1;
        }

        if(memory[i][j] > -2){
            return memory[i][j];
        }

        if(grid[i][j] == 1){
            return 0;
        }

        int[] anss = new int[4];
        visited[i][j] = true;
        anss[0] = bfs(grid, i + 1, j, visited, memory);
        anss[1] = bfs(grid, i - 1, j, visited, memory);
        anss[2] = bfs(grid, i, j - 1, visited, memory);
        anss[3] = bfs(grid, i, j + 1, visited, memory);
        visited[i][j] = false;
        int ans = -1;
        for(int cur : anss){
            if(cur == -1){
                continue;
            }else if(ans == -1){
                ans = cur;
            }else {
                ans = Math.min(ans, cur);
            }
        }
        return ans == -1 ? -1 : ans + 1;
    }

    //多源bfs：bfs的起点可以是多个
    public static int maxDistance2(int[][] grid){
        int n = grid.length;
        //使用数组+指针模拟一个List<int[]>
        int[][] queue = new int[n * n][2];
        int l = 0, r = 0;
        boolean[][] visited = new boolean[n][n];

        int lands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    visited[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    lands++;
                }
            }
        }
        if(lands == 0 || lands == n * n){
            return -1;
        }

        int[] move = {-1, 0, 1, 0, -1};
        // for(int i = 0; i < 4; i++)(x + move[i],y + move[i + 1]) 即模拟了四个方向移动
        int level = 0;
        while(l < r){
            int size = r - l;
            for (int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + move[j];
                    int ny = y + move[j + 1];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                    }
                }
            }
            level++;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        int res = maxDistance2(grid);
        System.out.println(res);
    }
}
