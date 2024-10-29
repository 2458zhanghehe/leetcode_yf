package com.company.Bishi.baidu;

import java.util.Scanner;

public class P2_old {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bu = new int[n + 1];
        int m = sc.nextInt();
        int[] xi = new int[m];
        for (int i = 0; i < m; i++) {
            xi[i] = sc.nextInt();
        }
        int[] colorCount = new int[m + 1];
        colorCount[0] = n;
        int curKinds = 1;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= xi[i]; j++) {
                colorCount[bu[j]]--;
                if(colorCount[bu[j]] == 0){
                    curKinds--;
                }
                bu[j] = i + 1;
                if(colorCount[bu[j]] == 0){
                    curKinds++;
                }
                colorCount[bu[j]]++;
            }
            ans[i] = curKinds;
        }
        for (int i = 0; i < m; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
