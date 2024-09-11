package com.company.Dp;

import java.util.HashMap;
import java.util.HashSet;

// leetcode 873 最长的斐波那契子序列的长度
public class LenLongestFibSubseq {
    public static int lenLongestFibSubseq1(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int cur : arr){
            set.add(cur);
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int cur = 2;
                int x = arr[i];
                int y = arr[j];
                while(set.contains(x + y)){
                    int tmp = x;
                    x = y;
                    y = tmp + y;
                    cur++;
                    ans = Math.max(ans, cur);
                }
            }
        }
        return ans;
    }

    //https://acoier.com/2022/07/09/873.%20%E6%9C%80%E9%95%BF%E7%9A%84%E6%96%90%E6%B3
    // %A2%E9%82%A3%E5%A5%91%E5%AD%90%E5%BA%8F%E5%88%97%E7%9A%84%E9%95%BF%E5%BA%A6%EF
    // %BC%88%E4%B8%AD%E7%AD%89%EF%BC%89/
    public static int lenLongestFibSubseq2(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[len][len];
        int ans = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < i; j++) {
                Integer t = map.getOrDefault(arr[i] - arr[j], -1);
                if(t == -1){
                    continue;
                }
                dp[i][j] = Math.max(3, dp[j][t] + 1);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(lenLongestFibSubseq1(nums));
        System.out.println(lenLongestFibSubseq2(nums));
    }
}
