package com.company.practice.GreatFactoryP;

public class RotateMatrix_p {
    //顺时针旋转90度正方形矩阵
    public static void rotateMatrix(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix.length - 1;
        while (a < c) {
            process(matrix, a++, b++, c--, d--);
        }
    }

    public static void process(int[][] matrix, int a, int b, int c, int d) {
        for (int i = 0; i < d - b; i++) {
            int tmp = matrix[a][b + i];
            matrix[a][b + i] = matrix[c - i][b];
            matrix[c - i][b] = matrix[c][d - i];
            matrix[c][d - i] = matrix[a + i][d];
            matrix[a + i][d] = tmp;
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
        rotateMatrix(matrix);
        System.out.println("################");
        printMatrix(matrix);
    }
}
