package com.company.GreatFactoryProblem;

//leetcode 54
public class PrintMatrixSpiralOrder {
    public static void printMatrixSpiralOrder(int[][] matrix) {
        int LUp_x = 0;
        int LUp_y = 0;
        int RD_x = matrix.length - 1;
        int RD_y = matrix[0].length - 1;
        while (LUp_x <= RD_x && LUp_y <= RD_y) {
            process(matrix, LUp_x++, LUp_y++, RD_x--, RD_y--);
        }
    }

    public static void process(int[][] matrix, int lux, int luy, int rdx, int rdy) {
        if (lux == rdx) {
            for (int i = luy; i <= rdy; i++) {
                System.out.println(matrix[lux][i]);
            }
        } else if (luy == rdy) {
            for (int i = lux; i <= rdx; i++) {
                System.out.println(matrix[i][luy]);
            }
        } else {
            for (int i = luy; i <= rdy; i++) {
                System.out.print(matrix[lux][i] + " ");
            }
            for (int i = lux + 1; i <= rdx; i++) {
                System.out.print(matrix[i][rdy] + " ");
            }
            for (int i = rdy - 1; i >= luy; i--) {
                System.out.print(matrix[rdx][i] + " ");
            }
            for (int i = rdx - 1; i > lux; i--) {
                System.out.print(matrix[i][luy] + " ");
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        printMatrixSpiralOrder(matrix);
    }
}
