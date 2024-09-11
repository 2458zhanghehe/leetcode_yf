package com.company.Bishi.dewu;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numsA = new int[n];
        int [] numsB = new int[n];
        for (int i = 0; i < n; i++) {
            numsA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            numsB[i] = sc.nextInt();
        }

        int ans = 0;
        int cur = 1;
        for(int r = 1; r < n; r++){
            if(numsA[r] - numsA[r - 1] == numsB[r] - numsB[r - 1]){
                cur++;
                ans = Math.max(ans, cur);
            }else {
                cur = 1;
            }
        }
        System.out.println(ans);
    }
}
