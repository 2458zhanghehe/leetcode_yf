package com.company.BFS;

import java.util.ArrayDeque;

// 1368 使网格图至少有一条有效路径的最小代价  左程云算法讲解062 01bfs
public class MinCost {
    public static int minCost(int[][] grid) {
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0, 0});
        distance[0][0] = 0;
        while(!deque.isEmpty()){
            int[] loc = deque.pollFirst();
            int x = loc[0];
            int y = loc[1];
            if(x == m - 1 && y == n - 1){
                return distance[x][y];
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + move[k][0];
                int ny = y + move[k][1];
                int newDis = distance[x][y] + (grid[x][y] == k + 1 ? 0 : 1);
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && newDis < distance[nx][ny]){
                    distance[nx][ny] = newDis;
                    if(grid[x][y] == k + 1){
                        deque.addFirst(new int[]{nx, ny});
                    }else {
                        deque.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 3}, {3, 2, 2}, {1, 1, 4}};
        System.out.println(minCost(grid));
    }
}
