package com.company.BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

//407 接雨水Ⅱ 左程云算法讲解062  第5题 BFS与优先级队列相结合
public class TrapRainWater2 {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int ans = 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            priorityQueue.add(new int[]{0, j, heightMap[0][j]});
            priorityQueue.add(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            priorityQueue.add(new int[]{i, 0, heightMap[i][0]});
            priorityQueue.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }

        int[] move = {-1, 0, 1, 0, -1};
        while(!priorityQueue.isEmpty()){
            int[] curEdge = priorityQueue.poll();
            int x = curEdge[0];
            int y = curEdge[1];
            int height = curEdge[2];
            for (int k = 0; k < 4; k++) {
                int nx = x + move[k];
                int ny = y + move[k + 1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(heightMap[nx][ny] >= height){
                        priorityQueue.add(new int[]{nx, ny, heightMap[nx][ny]});
                    }else {
                        //洼地结算，并将height抬高到和边界相同
                        ans += height - heightMap[nx][ny];
                        priorityQueue.add(new int[]{nx, ny, height});

                    }
                }
            }
        }
        return ans;
    }
}
