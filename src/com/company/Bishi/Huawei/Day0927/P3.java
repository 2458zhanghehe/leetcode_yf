package com.company.Bishi.Huawei.Day0927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//多源bfs  可以使用数组模拟队列，也可以直接使用队列， 但l,r两个指针跑不了
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();


        int[][] info = new int[M][N];
        int[][] queue = new int[M * N][2];
        int l = 0;
        int r = 0;
        ArrayList<int[]> liveList = new ArrayList<>();
        int[][] ans = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                info[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[M][N];
        int[][] value = new int[M][N];
        //build
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(info[i][j] == 0){
                    ans[i][j] = -1;
                }
                if(info[i][j] == 1){
                    ans[i][j] = -1;
                    value[i][j] = -1;
                    visited[i][j] = true;
                }
                if(info[i][j] == 2){
                    ans[i][j] = 0;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    value[i][j] = a2;
                    visited[i][j] = true;
                }
                if(info[i][j] == 3){
                    ans[i][j] = 0;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                    value[i][j] = a1;
                    visited[i][j] = true;
                }
                if(info[i][j] == 4){
                    int[] cur = new int[3];
                    cur[0] = i;
                    cur[1] = j;
                    cur[2] = b2;   //不带口罩的人的感染阈值
                    liveList.add(cur);
                }
                if(info[i][j] == 5){
                    int[] cur = new int[3];
                    cur[0] = i;
                    cur[1] = j;
                    cur[2] = b1;   //带口罩的人感染阈值
                    liveList.add(cur);
                }
            }
        }

        int[] direct = {-1, 0, 1, 0, -1};
        int day = 1;
        while(true){
            while(l < r){
                int right = r;
                for (int i = l; i < right; i++) {
                    int x = queue[i][0];
                    int y = queue[i][1];
                    for (int j = 0; j < 4; j++) {
                        int nx = direct[j] + x;
                        int ny = direct[j + 1] + y;
                        if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && value[nx][ny] != -1){
                            visited[nx][ny] = true;
                            value[nx][ny] = Math.max(value[nx][ny], value[x][y] - 1);
                            queue[r][0] = nx;
                            queue[r++][1] = ny;
                        }
                    }
                }
                l = right;
            }
            for (int i = 0; i < liveList.size(); i++) {
                int[] live = liveList.get(i);
                if(value[live[0]][live[1]] >= live[2]){
                    ans[live[0]][live[1]] = day;
                    queue[r][0] = live[0];
                    queue[r++][1] = live[1];
                    value[live[0]][live[1]] = live[2] == b1 ? a1 : a2;
                    liveList.remove(i);
                    i--;
                    for (int j = 0; j < M; j++) {
                        Arrays.fill(visited[j], false);
                    }
                }
            }
            if(liveList.isEmpty()){
                break;
            }
            if(l == r){
                for(int[] live : liveList){
                    ans[live[0]][live[1]] = -1;
                }
                break;
            }
            day++;
        }
        for (int i = 0; i < M; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
