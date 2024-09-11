package com.company.Bishi.shouQianBa;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        int ans = 0;
        int count = 0;
        for(char cur : str.toCharArray()){
            if(cur == '('){
                count++;
            }else {
                count--;
            }
            if(count < 0){
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
