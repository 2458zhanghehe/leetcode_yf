package com.company.Bishi.meituan.Day0309;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int option = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        if(n != str.length()){
            return;
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == 'M' || str.charAt(i) == 'T'){
                sum++;
            }
        }

        if(sum + option >= n){
            System.out.println(n);
        }else {
            System.out.println(sum + option);
        }
    }
}
