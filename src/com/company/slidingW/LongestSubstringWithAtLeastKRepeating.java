package com.company.slidingW;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeating {
    public static int longestSubstring(String str, int k) {
        char[] s = str.toCharArray();
        int[] cnts = new int[256];
        int n = s.length;
        int ans = 0;
        //每次要求子串必须含有require种字符，每种字符都必须>k次
        //str:a-z的小写字母构成
        for (int require = 1; require < 26; require++) {
            Arrays.fill(cnts, 0);
            // collect_c为收集到的种类数，satify_c为满足每种都>K的种类数
            for (int l = 0, r = 0, collect_c = 0, satify_c = 0; r < n; r++) {
                cnts[s[r]]++;
                if (cnts[s[r]] == 1) {
                    collect_c++;
                }
                if (cnts[s[r]] == k) {
                    satify_c++;
                }
                while (collect_c > require) {
                    if (cnts[s[l]] == 1) {
                        collect_c--;
                    }
                    if (cnts[s[l]] == k) {
                        satify_c--;
                    }
                    cnts[s[l++]]--;
                }
                if (satify_c == require) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }
}
