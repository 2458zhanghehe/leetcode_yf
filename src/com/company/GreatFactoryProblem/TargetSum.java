package com.company.GreatFactoryProblem;

import java.util.HashMap;

//leetcode 494
public class TargetSum {
    public static int findTargetSumWays1(int[] arr, int target) {
        return process(arr, 0, target);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        return process(arr, index + 1, rest - arr[index]) +
                process(arr, index + 1, rest + arr[index]);
    }

    //傻动态规划
    public static int findTargetSumWays2(int[] arr, int target) {
        return process2(arr, 0, target, new HashMap<>());
    }

    public static int process2(int[] arr, int index, int rest,
                               HashMap<Integer, HashMap<Integer, Integer>> hashmap) {
        if (hashmap.containsKey(index) && hashmap.get(index).containsKey(rest)) {
            return hashmap.get(index).get(rest);
        }
        int ans = 0;
        if (index == arr.length) {
            ans = rest == 0 ? 1 : 0;
        } else {
            ans = process2(arr, index + 1, rest + arr[index], hashmap) +
                    process2(arr, index + 1, rest - arr[index], hashmap);
        }
        if (!hashmap.containsKey(index)) {
            hashmap.put(index, new HashMap<>());
        }
        hashmap.get(index).put(rest, ans);
        return ans;
    }
}
