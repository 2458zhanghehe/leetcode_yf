package com.company.Bishi.meituan.Day0309;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int mod = 1;
        while(--k >= 0){
            mod *= 10;
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int sum = 1;
                for(int t = 0; t < n; t++){
                    if(t >= i && t <= j){
                        continue;
                    }
                    sum *= nums[t];
                }
                if((sum % mod) == 0){
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }
}
