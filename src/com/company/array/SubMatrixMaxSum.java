package com.company.array;

public class SubMatrixMaxSum {
    public int subMatrixMaxSum(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            //注意这里数组的使用节约了一个for循环
            int[] subSum = new int[matrix[0].length];
            for(int j = i; j < matrix.length; j++){
                int cur = 0;
                for(int k = 0; k < matrix[0].length; k++){
                    subSum[k] += matrix[j][k];
                    cur += subSum[k];
                    max = Math.max(cur,max);
                    if(cur < 0){
                        cur = 0;
                    }
                }
            }
        }
        return max;
    }
}
