package com.company.matrix;

//leetCode48  左101
public class RotateMatrix {
    //顺时针旋转90度正方形矩阵
    public static void rotateMatrix(int[][] matrix) {
        int lux = 0;
        int luy = 0;
        int rdx = matrix.length - 1;
        int rdy = matrix.length - 1;
        while (lux < rdx) {
            process(matrix, lux++, luy++, rdx--, rdy--);
        }
    }

    public static void process(int[][] matrix, int lux, int luy, int rdx, int rdy) {
        int tmp;
        for (int i = 0; i < rdy - luy; i++) {
            tmp = matrix[lux][luy + i];
            matrix[lux][luy + i] = matrix[rdx - i][luy];
            matrix[rdx - i][luy] = matrix[rdx][rdy - i];
            matrix[rdx][rdy - i] = matrix[lux + i][rdy];
            matrix[lux + i][rdy] = tmp;
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
