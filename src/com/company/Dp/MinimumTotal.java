package com.company.Dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int ans = process(triangle,0,0,triangle.size());
        return ans;
    }

    private static int process(List<List<Integer>> triangle, int i, int j, int size) {
        if(i == size - 1){
            return triangle.get(i).get(j);
        }
        return Math.min(process(triangle,i + 1, j, size),process(triangle, i + 1, j + 1, size)) + triangle.get(i).get(j);
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for(int j = 0; j < size; j++){
            dp[size - 1][j] = triangle.get(size - 1).get(j);
        }

        for(int i = size - 2; i >= 0; i--){
            for(int j = 0; j < i + 1; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        int ans = minimumTotal2(list);
        System.out.println(ans);

    }
}
