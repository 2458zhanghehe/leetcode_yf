package com.company.Bishi.redbook;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] test = new int[t][4];
        for (int i = 0; i < t; i++) {
            test[i][0] = sc.nextInt();
            test[i][1] = sc.nextInt();
            test[i][2] = sc.nextInt();
            test[i][3] = sc.nextInt();
        }
        for (int cur = 0; cur < t; cur++) {
            int x = test[cur][0];
            int y = test[cur][1];
            int z = test[cur][2];
            int k = test[cur][3];

            if(k > x * y * z){
                System.out.println(0);
                continue;
            }
            if(k == x * y * z){
                System.out.println(1);
                continue;
            }
            int ans = 0;
            for(int i = 1; i <= x; i++){
                if(k % i != 0){
                    continue;
                }
                int yz = k / i;
                for(int j = 1; j <= y; j++){
                    if(yz % j != 0){
                        continue;
                    }
                    int dz = yz / j;
                    if(dz > z){
                        continue;
                    }
                    ans = Math.max(ans, (x - i + 1) * (y - j + 1) * (z - dz + 1));
                }
            }
            System.out.println(ans);
        }
    }
}
