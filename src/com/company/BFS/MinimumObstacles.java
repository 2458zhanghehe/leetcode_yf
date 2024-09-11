package com.company.BFS;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

// 2290 到达角落需要移除障碍物的最小数目  左程云算法讲解062 01bfs
public class MinimumObstacles {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[] move = {-1, 0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Deque<int[]> deque = new LinkedList<>();
        distance[0][0] = 0;
        deque.addFirst(new int[]{0, 0});
        while(!deque.isEmpty()){
            int[] loc = deque.pollFirst();
            if(loc[0] == m - 1 && loc[1] == n - 1){
                return distance[m - 1][n - 1];
            }

            for (int k = 0; k < 4; k++) {
                int ni = loc[0] + move[k];
                int nj = loc[1] + move[k + 1];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n && (distance[loc[0]][loc[1]] + grid[ni][nj]) < distance[ni][nj]){
                    distance[ni][nj] = distance[loc[0]][loc[1]] + grid[ni][nj];
                    if(grid[ni][nj] == 0){
                        deque.addFirst(new int[]{ni, nj});
                    }else {
                        deque.addLast(new int[]{ni, nj});
                    }
                }

            }
        }
        return -1;
    }
}
