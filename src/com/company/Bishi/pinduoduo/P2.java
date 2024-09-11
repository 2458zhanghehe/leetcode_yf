package com.company.Bishi.pinduoduo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String A = sc.nextLine();
        String B = sc.nextLine();

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < m - n; i++){
            int[] S = new int[n];
            for(int j = 0; j < n; j++){
                if(A.charAt(i + j) == B.charAt(j)){
                    S[j] = 0;
                }else {
                    S[j] = 1;
                }
            }
            int flag = S[0];
            for(int j = 1; j < n; j++){
                flag = flag ^ S[j];
            }
            if(flag == 0){
                set.add(Arrays.toString(S));
            }
        }
        System.out.println(set.size());
    }
}
