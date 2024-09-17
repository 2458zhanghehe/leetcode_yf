package com.company.Bishi.redbook;

import java.util.HashMap;
import java.util.Scanner;

public class P1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] articles = new int[n];
        for (int i = 0; i < n; i++) {
            articles[i] = sc.nextInt();
        }

        // dianzan: num
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        for(int article : articles){
            if(map.containsKey(article ^ k)){
                ans += map.get(article ^ k);
            }
            map.put(article, map.getOrDefault(article, 0) + 1);
        }
        System.out.println(ans);
    }
}
