package com.company.Bishi.didi;

import java.util.Arrays;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int q = sc.nextInt();
        int[][] operation = new int[q][3];
        for (int i = 0; i < q; i++) {
            operation[i][0] = sc.nextInt();
            operation[i][1] = sc.nextInt();
            operation[i][2] = sc.nextInt();
        }

        char[] chars = str.toCharArray();

        for (int i = q - 1; i >= 0; i--) {
            int l = operation[i][0];
            int r = operation[i][1];
            int step = operation[i][2];
            for (int j = l - 1; j <= r - 1; j++) {
                if(chars[j] - 'a' >= step){
                    chars[j] -= step;
                }else {
                    for (int k = 1; k <= step; k++) {
                        if(chars[j] == 'a'){
                            chars[j] = 'z';
                        }else {
                            chars[j]--;
                        }
                    }
                }
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
