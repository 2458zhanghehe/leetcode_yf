package com.company.Bishi.ant.Day0413;

import java.util.Scanner;

//P1与0316的p1相同
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

            boolean isT = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(chars[i][j] == '*'){
                        int curA = 0;
                        if(i - 1 >= 0 && chars[i - 1][j] == '*'){
                            curA++;
                        }
                        if(i + 1 < n && chars[i + 1][j] == '*'){
                            curA++;
                        }
                        if(j - 1 >= 0 && chars[i][j - 1] == '*'){
                            curA++;
                        }
                        if(j + 1 < m && chars[i][j + 1] == '*'){
                            curA++;
                        }
                        if(curA == 3){
                            isT = true;
                            break;
                        }
                    }
                }
            }

            if(isT){
                System.out.println("T");
            }else {
                System.out.println("L");
            }
        }
    }
}
