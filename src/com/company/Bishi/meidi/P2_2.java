package com.company.Bishi.meidi;

import java.util.Scanner;

public class P2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        while(num2 != 0){
           int temp = num1;
           num1 = num2;
           num2 = temp % num2;
        }
        System.out.println(num1);
    }
}
