package com.company.slidingW;

import java.util.Arrays;

//无重复字符最长子串 左35  leetcode 3
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String str) {
        char[] s = str.toCharArray();
        //char转为int对应范围只有0-255，所以记录char的位置、词频
        // 等可以直接使用255数组，不需要只有小写字母才能用
        int[] lastlocation = new int[256];
        Arrays.fill(lastlocation, -1);
        int ans = -1;
        for (int L = 0, R = 0; R < s.length; R++) {
            L = Math.max(L, lastlocation[s[R]] + 1);
            ans = Math.max(ans, R - L + 1);
            lastlocation[s[R]] = R;
        }
        return ans;
    }

}
