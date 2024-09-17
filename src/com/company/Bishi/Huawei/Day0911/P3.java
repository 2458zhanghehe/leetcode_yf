package com.company.Bishi.Huawei.Day0911;

import java.util.Arrays;
import java.util.Scanner;
//基站最大盈利
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] works = new int[m][3];
        for (int i = 0; i < m; i++) {
            works[i][0] = sc.nextInt();
            works[i][1] = sc.nextInt();
            works[i][2] = sc.nextInt();
        }
        Arrays.sort(works, (a, b) -> {return a[0] - b[0];});
        boolean[] visited = new boolean[n + 1];
        int ans = process(0, works, visited);
        System.out.println(ans);
    }

    private static int process(int i, int[][] works, boolean[] visited) {
        if(i == works.length){
            return 0;
        }
        int ans1 = process(i + 1, works, visited);
        int ans2 = 0;
        if(!visited[works[i][0]]){
            for(int k = works[i][0]; k <= works[i][1]; k++){
                visited[k] = true;
            }
            ans2 = process(i + 1, works, visited) + works[i][2];
            for(int k = works[i][0]; k <= works[i][1]; k++){
                visited[k] = false;
            }
        }

        return Math.max(ans1, ans2);
    }
}
