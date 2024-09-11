package com.company.Bishi.Ali.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] fans = new int[n][3];
        for (int i = 0; i < n; i++) {
            fans[i][0] = sc.nextInt();
            fans[i][1] = sc.nextInt();
            fans[i][2] = i + 1;
        }

        Arrays.sort(fans, (o1, o2) -> {
            if((o1[0] + o1[1] * 2) == (o2[0] + o2[1] * 2)){
                return o2[1] == o1[1] ? o1[2] - o2[2] : o2[1] - o1[1];
            }else {
                return (o2[0] + o2[1] * 2) - (o1[0] + o1[1] * 2);
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = fans[i][2];
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
