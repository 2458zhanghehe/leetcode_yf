package com.company.Dp;

public class LongestValidParentheses {
    //leetcode32
    public static int longestValidParentheses1(String s) {
        int count = 0;
        int ans = 0;
        int lengI = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == 0) {
                ans = Math.max(ans, lengI);
                if (s.charAt(i) == ')') {
                    lengI = 0;
                    continue;
                }
            }
            lengI++;
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }

        }
        ans = (count == 0) ? Math.max(ans, lengI - count) : ans;

        count = 0;
        lengI = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == 0) {
                ans = Math.max(ans, lengI);
                if (s.charAt(i) == '(') {
                    lengI = 0;
                    continue;
                }
            }
            lengI++;
            if (s.charAt(i) == ')') {
                count++;
            } else {
                count--;
            }
        }
        ans = (count == 0) ? Math.max(ans, lengI - count) : ans;
        return ans;
    }

    public static int longestValidParentheses2(String s) {
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = i - 1 - dp[i - 1];
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((pre - 1) > 0 ? dp[pre - 1] : 0);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses1(s));
        System.out.println(longestValidParentheses2(s));
    }
}
