package com.company.matrix;

//leetcode 74 搜索二维矩阵
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while(i < m && matrix[i][j] < target){
            i++;
        }
        for(; j >= 0 && i < m; j--){
            if(matrix[i][j] == target){
                return true;
            }
        }
        return false;
    }
}
