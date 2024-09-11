package com.company.practice.GreatFactoryP;

import java.util.HashSet;

//leetcode 532
public class SubValueEqualK_p {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        if (k == 0) {
            HashSet<Integer> help = new HashSet<>();
            for (Integer tmp : nums) {
                if (set.contains(tmp) && !help.contains(tmp)) {
                    ans++;
                    help.add(tmp);
                }
                set.add(tmp);
            }
        } else {
            for (Integer tmp : nums) {
                set.add(tmp);
            }
            for (Integer cur : set) {
                if (set.contains(cur + k)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
