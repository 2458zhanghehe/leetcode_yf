package com.company.GreatFactoryProblem;

import java.util.*;

//leetcode 532
public class SubValueEqualK {
    public static List<List<Integer>> subValueEqualK1(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        List<List<Integer>> res = new LinkedList<>();
        for (Integer tmp : set) {
            if (set.contains(tmp + k)) {
                res.add(Arrays.asList(tmp, tmp + k));
            }
        }
        return res;
    }

    public static List<List<Integer>> subValueEqualK2(int[] arr, int k) {
        Arrays.sort(arr);
        int L = 0;
        int R = 0;
        List<List<Integer>> res = new LinkedList<>();
        while (R < arr.length) {
            if (arr[R] - arr[L] < k) {
                R++;
            } else if (arr[R] - arr[L] == k) {
                Arrays.asList(arr[L], arr[R]);
            } else {
                L++;
            }
        }
        return res;
    }

}
