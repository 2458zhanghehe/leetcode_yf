package com.company.practice.slidng_windows_practice;

import java.util.Arrays;

public class LongSubStringWithKRepeat {
    public static int longestSubstring(String s, int k) {
        char[] s_char = s.toCharArray();
        int[] cnts = new int[256];
        int ans = -1;
        for (int require = 1; require <= 26; require++) {
            Arrays.fill(cnts, 0);
            for (int l = 0, r = 0, collect = 0, satisfy = 0; r < s.length(); r++) {
                if (++cnts[s_char[r]] == 1) {
                    collect++;
                }
                if (++cnts[s_char[r]] == k) {
                    satisfy++;
                }
                while (collect > require) {
                    if (cnts[s_char[l]] == 1) {
                        collect--;
                    }
                    if (cnts[s_char[l]] == k) {
                        satisfy--;
                    }
                    cnts[s_char[l++]]--;
                }
                if (satisfy == require) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;

    }
}
