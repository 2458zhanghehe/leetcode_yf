package com.company.Bishi.xiecheng;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] nums = new int[n][m];
        for(int i = 0; i < n; i++){
            String cur = sc.nextLine();
            for(int j = 0; j < cur.length(); j++){
                nums[i][j] = cur.charAt(j) - 48;
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == 0){
                    ans++;
                    if(j + 1 < m && nums[i][j + 1] == 0){
                        j++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
