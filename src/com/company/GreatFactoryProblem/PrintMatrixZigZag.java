package com.company.GreatFactoryProblem;

public class PrintMatrixZigZag {
    public static void printMatrixZigZag(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        boolean fromUp = false;
        do {
            printLine(matrix, a, b, c, d, fromUp);
//            if(b == matrix[0].length - 1){
//                a++;
//            }else {
//                b++;
//            }
//            if(c == matrix.length - 1){
//                d++;
//            }else {
//                c++;
//            }
            a = (b == matrix[0].length - 1) ? a + 1 : a;
            b = (b == matrix[0].length - 1) ? b : b + 1;
            d = (c == matrix.length - 1) ? d + 1 : d;  //注意，d应该在c可能改变之前判断
            c = (c == matrix.length - 1) ? c : c + 1;
            fromUp = !fromUp;
        } while (a <= c || b >= d);

    }

    public static void printLine(int[][] matrix, int a, int b, int c, int d, boolean fromUp) {
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

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        printMatrixZigZag(matrix);
    }
}
