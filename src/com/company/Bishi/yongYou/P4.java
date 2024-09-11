package com.company.Bishi.yongYou;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tasks = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tasks[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int[][] days = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                days[i][j] = sc.nextInt();
            }
        }

        int ans = process(0, 0, tasks, days, new boolean[n], n);
        System.out.println(ans);
    }

    private static int process(int iTask, int iWeek, int[][] tasks, int[][] days,
                               boolean[] hasDone, int n) {
        if (iWeek == days[0].length) {
            return 0;
        }
        boolean allDone = true;
        for (int i = 0; i < hasDone.length; i++) {
            if(!hasDone[i]){
                allDone = false;
            }
        }
        if(allDone){
            return 0;
        }

        int ans = -1;
        for (int j = 0; j < n; j++) {
            if ((tasks[iTask][j] == 1 || iTask == j) && !hasDone[j]) {
                hasDone[j] = true;
                int cur = process(j, iWeek + 1, tasks, days, hasDone, n) + days[j][iWeek];
                if (cur != -1) {
                    ans = Math.max(ans, cur);
                }
                hasDone[j] = false;
            }
        }
        return ans;
    }
}
