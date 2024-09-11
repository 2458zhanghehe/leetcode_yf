package com.company.Bishi.jd;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(--t >= 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int sum = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }

            if(n == 1){
                System.out.println(0);
                continue;
            }

            if(n <= k){
                int cur = 0;
                for (int i = 0; i < arr.length; i++) {
                    cur += arr[i];
                }
                System.out.println(cur > sum ? cur - sum : 0);
                continue;
            }

            int ans = 0;
            while(true){
                int cur = arr[arr.length - 1];
                for (int i = arr.length - 2; i >= arr.length - k; i--) {
                    cur += arr[i];
                }
                if(cur <= sum){
                    break;
                }

                if(cur > sum + k){
                    ans += k;
                    for (int i = arr.length - 1; i >= arr.length - k; i--) {
                        arr[i]--;
                    }
                }else {
                    ans++;
                    arr[arr.length - 1]--;
                }
                Arrays.sort(arr);
            }
            System.out.println(ans);
        }
    }
}
