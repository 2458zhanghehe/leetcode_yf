package com.company.Bishi.Huawei.Day0417;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        char[] chars = new char[n];
        for(int i = 0; i < n; i++){
            chars[i] = str.charAt(2 * i);
        }

        for(int i = 0; i < n - 2; i++){
            if(chars[i] == chars[i + 1] && chars[i] == chars[i + 2]){
                if(n - 3 <= 0){
                    System.out.print(0);
                    return;
                }
                char[] copy = new char[n - 3];
                for(int j = 0; j < n - 3; j++){
                    if(j < i){
                        copy[j] = chars[j];
                    }else {
                        copy[j] = chars[j + 3];
                    }
                }
                chars = copy;
                n = n - 3;
                i = -1;
            }
        }

        for(int i = 0; i < chars.length - 1; i++){
            System.out.print(chars[i] + " ");
        }
        System.out.print(chars[chars.length - 1]);
    }
}
