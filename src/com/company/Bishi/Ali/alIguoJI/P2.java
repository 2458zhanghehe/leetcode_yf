package com.company.Bishi.Ali.alIguoJI;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = process(n, 0, 0);
        System.out.println(ans);

    }

    private static int process(int n, int index, int pre) {
        if(index == n){
            return 0;
        }

        int ans = 0;
        if(pre == 0){
            ans += process(n, index + 1, 0);
            ans += process(n, index + 1, 1);
        }else {
            ans += process(n, index + 1, 0);
            ans += process(n, index + 1, 1) + 1;
        }
        return ans;
    }
}
