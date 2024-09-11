package com.company.BFS;

import java.util.Arrays;

//LCR 107 01矩阵  和1162很像，都是多源dfs：bfs的起点可以是多个
public class UpdateMatrix {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] queue = new int[m * n][2];
        int l = 0, r = 0;
        int[][] ans = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    ans[i][j] = 0;
                }
            }
        }

        int curLevel = 0;
        int[] move = {-1, 0, 1, 0, -1};
        while(l < r){
            int size = r - l;
            for (int i = 0; i < size; i++) {
                int x = queue[l][0];
                int y = queue[l++][1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + move[j];
                    int ny = y + move[j + 1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        ans[nx][ny] = curLevel + 1;
                        queue[r][0] = nx;
                        queue[r++][1] = ny;
                    }
                }
            }
            curLevel++;
        }
        return ans;
    }
}
