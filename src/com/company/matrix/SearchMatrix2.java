package com.company.matrix;

//leetcode 240 搜索二位矩阵Ⅱ
public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        return process(matrix, 0, n - 1, target, m ,n);
    }

    private boolean process(int[][] matrix, int x, int y, int target, int m, int n) {
        while(matrix[x][y] <= target){
            if(matrix[x][y] == target){
                return true;
            }
            x++;
            if(x == m){
                return false;
            }
        }
        while(matrix[x][y] >= target){
            if(matrix[x][y] == target){
                return true;
            }
            y--;
            if(y < 0){
                return false;
            }
        }
        return process(matrix, x, y, target, m, n);
    }
}
