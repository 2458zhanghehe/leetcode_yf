package com.company.Bishi.meituan.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Juan1_P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] chars = new char[m][n];
        sc.nextLine();
        for(int i = 0; i < m; i++){
            String curLine = sc.nextLine();
            for(int j = 0; j < n; j++){
                chars[i][j] = curLine.charAt(j);
            }
        }
        //        for(int i = 0; i < m; i++){
//            System.out.println(Arrays.toString(chars[i]));
//        }

        int ans = 0;
        for(int i = 0; i + 2 < m; i++){
            for(int j = 0; j + 2 < n; j++){
                boolean check_ans = check(chars,i,j);
                ans += check_ans ? 1 : 0;
            }
        }
        System.out.print(ans);
    }

    private static boolean check(char[][] chars, int i, int j){
        boolean[] flag = new boolean[3];
        Arrays.fill(flag,false);

        char[][] curChar = new char[3][3];
        for(int x = i; x < i + 3; x++){
            for(int y = j; y < j + 3; y++){
                curChar[x - i][y - j] = chars[x][y];
            }
        }

        for(int ii = 0; ii < 3; ii++){
            for(int jj = 0; jj < 3; jj++){
                int index = curChar[ii][jj] - 65;
                if(index < 3 && index >= 0){
                    flag[index] = true;
                    boolean checkNE = checkNotEquals(curChar,ii,jj);
                    if(!checkNE){
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        for(boolean tmp : flag){
            if(!tmp){
                return false;
            }
        }
        return true;
    }

    private static boolean checkNotEquals(char[][] chars, int x, int y) {
        return (process(chars, x - 1, y, x ,y) &
        process(chars, x + 1, y, x ,y) &
        process(chars, x, y - 1, x ,y) &
        process(chars, x, y + 1, x ,y));
    }

    private static boolean process(char[][] chars, int a, int b, int x, int y) {
        if(a < 0 || a >= chars.length || b < 0 || b >= chars[0].length){
            return true;
        }
        return chars[a][b] != chars[x][y];
    }
}
