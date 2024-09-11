package com.company.Bishi.xiecheng;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if((i & 1) == 0){
                sb.append("you");
            }else {
                sb.append("uoy");
            }
        }
        System.out.print(sb.toString());
    }
}
