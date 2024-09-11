package com.company.practice.GreatFactoryP;

public class PrintMatrixZigZag_p {
    public static void printMatrixZigZag_p(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        boolean fromUp = false;
        do {
            process(matrix, a, b, c, d, fromUp);
            a = (b == matrix[0].length - 1) ? a + 1 : a;
            b = (b == matrix[0].length - 1) ? b : b + 1;
            d = (c == matrix.length - 1) ? d + 1 : d;
            c = (c == matrix.length - 1) ? c : c + 1;
            fromUp = !fromUp;
        } while (a != c && b != d);
        System.out.print(matrix[a][b] + " ");
    }

    public static void process(int[][] matrix, int a, int b, int c, int d, boolean fromUp) {
        if (fromUp) {
            while (b >= d) {
                System.out.print(matrix[a++][b--] + " ");
            }
        } else {
            while (d <= b) {
                System.out.print(matrix[c--][d++] + " ");
            }
        }
    }
}
