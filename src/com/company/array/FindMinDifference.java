package com.company.array;

import java.util.Arrays;
import java.util.List;

// leetcode 539.最小时间差
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < times.length; i++) {
            String cur = timePoints.get(i);
            int curMin = Integer.valueOf(cur.substring(0,2)) * 60 + Integer.valueOf(cur.substring(3,5));
            times[i] = curMin;
        }

        Arrays.sort(times);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < times.length - 1; i++) {
            int delta = times[i + 1] - times[i];
            ans = Math.min(ans, delta);
        }
        ans = Math.min(24 * 60 - times[times.length - 1] + times[0], ans);
        return ans;
    }

    public static void main(String[] args) {
        String str = "02";
        Integer a = Integer.valueOf(str);
        System.out.println(a);
    }
}
