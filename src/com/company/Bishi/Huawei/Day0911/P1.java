package com.company.Bishi.Huawei.Day0911;

import java.util.ArrayList;
import java.util.Scanner;

// 多源bfs   垃圾收集  最小距离和
public class P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    list.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int l = 0;
        int r = list.size();
        int level = 1;
        int[] move = {-1, 0, 1, 0, -1};
        while(l < r){
            for (int i = l; i < r; i++) {
                int[] cur = list.get(i);
                for (int k = 0; k < 4; k++) {
                    int x = cur[0] + move[k];
                    int y = cur[1] + move[k + 1];
                    if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] != -1){
                        visited[x][y] = true;
                        list.add(new int[]{x, y});
                        if(grid[x][y] == 1){
                            ans += level;
                        }
                    }
                }
            }
            level++;
            l = r;
            r = list.size();
        }
        System.out.println(ans);
    }
}
