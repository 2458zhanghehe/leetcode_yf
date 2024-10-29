package com.company.Bishi;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        int num = 1;
        int p1x = 0;
        int p1y = 0;
        int p2x = n - 1;
        int p2y = n - 1;
        while(p1x < p2x && p1y < p2y){
            for (int i = p1x; i <= p2x; i++) {
                grid[i][p2y] = num++;
            }
            for (int j = p2y - 1; j > p1y; j--) {
                grid[p2x][j] = num++;
            }
            for (int i = p2x; i >= p1x; i--) {
                grid[i][p1y] = num++;
            }
            for (int j = p1y + 1; j < p2y; j++) {
                grid[p1x][j] = num++;
            }
            p1x++;
            p1y++;
            p2x--;
            p2y--;
        }
        for(int[] row : grid){
            for(int cur : row){
                if(cur < 10){
                    System.out.print(" ");
                }
                System.out.print(" ");
                System.out.print(cur);
            }
            System.out.println();
        }
    }


//     10 11 12  1
//             9 16 13  2
//             8 15 14  3
//             7  6  5  4
//
//             10  11  12   1
//             9  16  13   2
//             8  15  14   3
//             7   6   5   4
//
//             10 11 12  1
//             9 16 13  2
//             8 15 14  3
//             7  6  5  4
}

