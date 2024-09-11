package com.company.matrix;

import java.util.Arrays;
import java.util.HashSet;

//leetcode 73
public class SetZeroes {
    public static void setZeroes(int[][] matrix) {

        HashSet<Integer> set_row = new HashSet<>();
        HashSet<Integer> set_col = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            if(set_row.contains(i)){
                continue;
            }
            for(int j = 0; j < n; j++){
                if(set_col.contains(j)){
                    continue;
                }
                if(matrix[i][j] == 0){
                    set_row.add(i);
                    process_row(matrix,i,j,set_row,set_col);
                    set_col.add(j);
                    process_col(matrix,i,j,set_row,set_col);
                }
            }
        }

        for(int i : set_row){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = 0;
            }
        }

        for(int j : set_col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][j] = 0;
            }
        }

    }

    private static void process_col(int[][] matrix, int i, int j,
                             HashSet<Integer> set_row, HashSet<Integer> set_col) {
        for(int x = 0; x < matrix.length; x++){
            if(x == i) continue;
            if(matrix[x][j] == 0 && !set_row.contains(x)){
                set_row.add(x);
                process_row(matrix,x,j,set_row,set_col);
            }
        }
    }

    private static void process_row(int[][] matrix, int i, int j,
                             HashSet<Integer> set_row, HashSet<Integer> set_col) {

        for(int y = 0; y < matrix[0].length; y++){
            if(y == j) continue;
            if(matrix[i][y] == 0 && (!set_col.contains(y))){
                set_col.add(y);
                process_col(matrix, i, y, set_row,set_col);
            }
        }
    }


    //额外空间复杂度O(m + n)
    public static void setZeroes2(int[][] matrix) {
        boolean[] set_row = new boolean[matrix.length];
        boolean[] set_col = new boolean[matrix[0].length];
        Arrays.fill(set_row,false);
        Arrays.fill(set_col,false);

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    set_row[i] = true;
                    set_col[j] = true;
                }
            }
        }

        for(int i = 0; i < set_row.length; i++){
            if(set_row[i]){
                for(int j = 0; j < matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < set_col.length; j++){
            if(set_col[j]){
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //重点 额外空间复杂度O(1)
    public static void setZeroes3(int[][] matrix) {
        boolean flag_row0 = false;
        boolean flag_col0 = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0){
                flag_row0 = true;
                break;
            }
        }
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                flag_col0 = true;
                break;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(flag_row0){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if(flag_col0){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3,9,4,6,2,4,0,1,7},
                                     {1,9,7,3,7,0,2,0,7},
                                     {1,8,9,9,4,6,1,1,8},
                                     {6,2,4,4,5,3,0,4,7},
                                     {4,6,9,3,7,8,1,3,7},
                                     {3,5,7,0,8,7,0,7,1},
                                     {6,0,2,4,8,7,0,2,2}};
        setZeroes(matrix);
    }
}
