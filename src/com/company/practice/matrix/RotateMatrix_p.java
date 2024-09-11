package com.company.practice.matrix;

import java.util.Stack;

//leetCode48  左101
public class RotateMatrix_p {
    public static void rotate(int[][] matrix) {

        int lu = 0;
        int rd = matrix.length - 1;


        while(lu < rd){
            process(matrix, lu++, rd--);
        }
    }

    private static void process(int[][] matrix, int lu, int rd){
        int len = rd - lu;
        for(int i = 0; i < len; i++){
            int tmp = matrix[rd - i][lu];
            matrix[rd - i][lu] = matrix[rd][rd - i];
            matrix[rd][rd - i] = matrix[lu + i][rd];
            matrix[lu + i][rd] = matrix[lu][lu + i];
            matrix[lu][lu + i] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 8, 10, 11}, {12, 13, 14, 15}};
        printMatrix(matrix);
        System.out.println("###########################");
        rotate(matrix);
        System.out.println("################");
        printMatrix(matrix);

        Stack<String> sta = new Stack<>();
        sta.add(null);
    }

}
