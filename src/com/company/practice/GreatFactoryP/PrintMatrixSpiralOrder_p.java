package com.company.practice.GreatFactoryP;

public class PrintMatrixSpiralOrder_p {
    //leetcode 54
    public static void printMatrixSpiralOrder(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            process(matrix, a++, b++, c--, d--);
        }
    }

    public static void process(int[][] matrix, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.println(matrix[a][i] + " ");
            }
            return;
        }
        if (b == d) {
            for (int i = a; i <= c; i++) {
                System.out.println(matrix[i][b] + " ");
            }
            return;
        }
        for (int i = b; i <= d; i++) {
            System.out.print(matrix[a][i] + " ");
        }
        for (int i = a + 1; i <= c; i++) {
            System.out.print(matrix[i][d] + " ");
        }
        for (int i = d - 1; i >= b; i--) {
            System.out.print(matrix[c][i] + " ");
        }
        for (int i = c - 1; i > a; i--) {
            System.out.print(matrix[i][b] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        printMatrixSpiralOrder(matrix);
    }
}
