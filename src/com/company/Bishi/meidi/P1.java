package com.company.Bishi.meidi;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {

        for(int i = 100; i <= 999; i++){
            boolean ishua = isHua(i);
            if(ishua){
                System.out.println(i);
            }
        }

    }

    private static boolean isHua(int num) {
        int copy = num;
        int a = num / 100;
        num = num % 100;
        int b = num / 10;
        int c = num % 10;
        if(a*a*a + b*b*b + c*c*c == copy){
            return true;
        }else {
            return false;
        }
    }


}
