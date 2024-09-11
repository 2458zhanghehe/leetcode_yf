package com.company.Bishi.meituan.Day0309;

import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            String cur = sc.nextLine();
            for(int j = 0; j < n; j++){
                matrix[i][j] = cur.charAt(j) - 48;
            }
        }

        for(int len = 1; len <= n; len++){
            if((len & 1) == 1){
                System.out.println(0);
                continue;
            }

            int count = 0;
            for(int i = 0; i + len - 1 < n; i++){
                for(int j = 0; j + len - 1 < n; j++){
                    int sum = sumMatrix(matrix, i , j , len);
                    if(2 * sum == len * len){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static int sumMatrix(int[][] matrix, int i, int j, int len) {
        int sum = 0;
        for(int m = i; m < i + len; m++){
            for(int n = j; n < j + len; n++){
                sum += matrix[m][n];
            }
        }
        return sum;
    }
}
