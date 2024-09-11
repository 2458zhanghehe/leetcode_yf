package com.company.Bishi.ant.Day0316;

import java.util.Arrays;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double k = sc.nextInt();
        double[] prices = new double[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        sc.nextLine();
        String str = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == '1'){
                prices[i] *= 0.95;
            }
        }
        Arrays.sort(prices);
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(k - prices[i] >= 0){
               ans++;
               k -= prices[i];
            }else {
                break;
            }
        }
        System.out.println(ans);
    }
}
