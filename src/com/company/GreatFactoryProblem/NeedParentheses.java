package com.company.GreatFactoryProblem;

import java.awt.image.BandedSampleModel;

//有效的括号字符串 leetcode678相似
public class NeedParentheses {
    public static int needParentheses(String s) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((count == 0) && (s.charAt(i) == ')')) {
                ans++;
                continue;
            }
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        ans += count;
        return ans;
    }
}
