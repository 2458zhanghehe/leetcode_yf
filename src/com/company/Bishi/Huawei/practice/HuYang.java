package com.company.Bishi.Huawei.practice;

import java.util.Arrays;
import java.util.Scanner;

public class HuYang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] dead = new int[M];
        for(int i = 0; i < M; i++){
            dead[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        if(k > M){
            System.out.println(N);
            return;
        }
        int ans1 = method1(N,M,dead,k);
        int ans2 = method2(N,M,dead,k);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    private static int method1(int n, int m, int[] dead, int k) {
        int ans = dead[k] - 1;
        for(int i = 1; i < m - k; i++){
            ans = Math.max(ans, dead[i + k] - dead[i - 1] - 1);
        }
        ans = Math.max(ans, n - dead[m - k - 1]);
        return ans;
    }

    private static int method2(int n, int m, int[] dead, int k) {
        int cnt = 0;

        int ans = 0;
        int[] nums = new int[n];
        Arrays.fill(nums,1);
        for(int i = 0; i < m; i++){
            nums[dead[i] - 1] = 0;
        }

        int l = 0;
        for(int r = 0; r < n; r++){
           if(nums[r] == 0){
               k -= 1;
           }
           while(k < 0){
               k += 1 - nums[l];
               l++;
           }
           ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
