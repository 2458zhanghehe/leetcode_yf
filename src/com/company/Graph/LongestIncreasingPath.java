package com.company.Graph;

//LCR 112 矩阵中的最长递增路径
public class LongestIncreasingPath {

    //加傻缓存版本
    public static int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memory = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = process(matrix, i ,j, m, n, memory);
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    private static int process(int[][] matrix, int i, int j, int m, int n, int[][] memory) {
        if(memory[i][j] > 0){
            return memory[i][j];
        }
        int ans = 0;
        if(i + 1 < m && matrix[i + 1][j] > matrix[i][j]){
            ans = process(matrix, i + 1, j, m, n, memory);
        }

        if(j + 1 < n && matrix[i][j + 1] > matrix[i][j]){
            int ans2 = process(matrix, i, j + 1, m, n, memory);
            ans = Math.max(ans, ans2);
        }

        if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]){
            int ans3 = process(matrix, i - 1, j, m, n, memory);
            ans = Math.max(ans, ans3);
        }

        if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]){
            int ans4 = process(matrix, i, j -1, m, n, memory);
            ans = Math.max(ans, ans4);
        }

        memory[i][j] = ans + 1;
        return ans + 1;
    }
}

