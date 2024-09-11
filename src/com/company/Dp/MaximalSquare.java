package com.company.Dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximalSquare {
    //想到之前的用空间换时间方法。左程云：边界全为1的最大正方形
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //down[i][j]表示(i,j)向下有多少个连续的1，包含(i,j)
        int[][] down = new int[m][n];
        for(int j = 0; j < n; j++){
            for(int i = m - 1; i >= 0; i--){
                if(matrix[i][j] == '0'){
                    down[i][j] = 0;
                }else {
                    down[i][j] = (i == m - 1) ? 1 : down[i + 1][j] + 1;
                }
            }
        }

        int[][] right = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = n - 1; j >= 0; j--){
                if(matrix[i][j] == '0'){
                    right[i][j] = 0;
                }else {
                    right[i][j] = (j == n - 1) ? 1 : right[i][j + 1] + 1;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int len = Math.min(down[i][j], right[i][j]);
                for(int l = 1; l < len; l++){
                    len = Math.min(len, Math.min(down[i + l][j + l], right[i + l][j + l]) + l);
                }
                ans = Math.max(ans,len*len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'}};

        maximalSquare(matrix);
    }
}
