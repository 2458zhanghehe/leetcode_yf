package com.company.Bishi.Huawei.Day0904;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

//二叉树消消乐
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] source = new int[n];
        for (int i = 0; i < n; i++) {
            source[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] reference = new int[m];
        for (int i = 0; i < m; i++) {
            reference[i] = sc.nextInt();
        }

        int[][] ans = new int[1000][2];
        for (int i = 0; i < 1000; i++) {
            ans[i][0] = i + 1;
        }

        int len = 1;
        int cur = 0;
        while(true){
            HashMap<Integer, Integer> referenceCurLevelMap = new HashMap<>();
            for (int i = cur; i < (cur + len) && i < m; i++) {
                referenceCurLevelMap.put(reference[i], referenceCurLevelMap.getOrDefault(reference[i], 0) + 1);
            }
            for (int i = cur; i < (cur + len) && i < n; i++) {
                if(referenceCurLevelMap.containsKey(source[i])){
                    Integer count = referenceCurLevelMap.get(source[i]);
                    if(count == 1){
                        referenceCurLevelMap.remove(source[i]);
                    }else {
                        referenceCurLevelMap.put(source[i], count - 1);
                    }
                }else {
                    ans[source[i] - 1][1]++;
                }
            }
            cur += len;
            len *= 2;
            if(cur >= n){
                break;
            }
        }

        Arrays.sort(ans, (o1, o2) -> {
            if(o1[1] != o2[1]){
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        for (int i = 0; i < 1000; i++) {
            if(ans[i][1] == 0){
                break;
            }
            System.out.print(ans[i][0] + " ");
        }
    }
}
