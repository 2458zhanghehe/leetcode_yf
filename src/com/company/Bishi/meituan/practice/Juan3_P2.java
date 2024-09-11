package com.company.Bishi.meituan.practice;

import java.util.HashSet;
import java.util.Scanner;

public class Juan3_P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            set.add(i);
        }

        int ans = -1;
        for(int i = 1; i <= m; i++){
            int t = sc.nextInt();
            int x = sc.nextInt();
            if(t == 1){
                set.remove(x);
            }else {
                if(set.contains(x)){
                    set.clear();
                    set.add(x);
                }else {
                    ans = i;
                    break;
                }
            }
            if(set.isEmpty()){
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }

}
