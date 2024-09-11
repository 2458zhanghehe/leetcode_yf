package com.company.Bishi.ant;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(--q >= 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] chars = new char[n][m];
            for(int i = 0; i < n; i++){
                String cur = sc.nextLine();
                for(int j = 0; j < m; j++){
                    chars[i][j] = cur.charAt(j);
                }
            }

            boolean end = false;
            for(int i = 0; i < n && !end; i++){
                for(int j = 0; j < m && !end; j++){
                    if(chars[i][j] == '*'){
                        //检查水平
                        int jj = j;
                        int index = -1;
                        while(jj < m && chars[i][jj] == '*'){
                            if(i + 1 < n && chars[i + 1][jj] == '*'){
                                index = jj;
                            }
                            jj++;
                        }
                        if(jj - 1 > j){
                            if(index == j || index == jj - 1){
                                System.out.println("L");
                                end = true;
                            }
                            if(index > j && index < jj - 1){
                                System.out.println("T");
                                end = true;
                            }
                        }
                        //检查垂直
                        if(!end){
                            int ii = i;
                            index = -1;
                            while(ii < n && chars[ii][j] == '*'){
                                if(j + 1 < m && chars[ii][j + 1] == '*'){
                                    index = ii;
                                }
                                if(j - 1 >= 0 && chars[ii][j - 1] == '*'){
                                    index = ii;
                                }
                                ii++;
                            }
                            if(ii - 1 >i){
                                if(index == i || index == ii - 1){
                                    System.out.println("L");
                                    end = true;
                                }
                                if(index > i && index < ii - 1){
                                    System.out.println("T");
                                    end = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
