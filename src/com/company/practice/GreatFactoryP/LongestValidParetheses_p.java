package com.company.practice.GreatFactoryP;

public class LongestValidParetheses_p {
    //leetCode 32
    public static int longestValidParentheses1(String s) {
        char[] str = s.toCharArray();
        int[] map = new int[str.length];
        int ans = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                int pre = i - 1 - map[i - 1];
                if (str[pre] == '(') {
                    map[i] = map[i - 1] + 2 + ((pre - 1 > 0) ? map[pre - 1] : 0);
                    ans = Math.max(ans, map[i]);
                }
            }
        }
        return ans;
    }

    public static int longestValidParentheses2(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int ans = 0;
        int lengI = 0;
        for (int i = 0; i < str.length; i++) {
            if (count == 0) {
                ans = Math.max(ans, lengI);
                if (str[i] == ')') {
                    lengI = 0;
                    continue;
                }
            }
            lengI++;
            if (str[i] == '(') {
                count++;
            } else {
                count--;
            }
        }
        ans = count == 0 ? Math.max(ans, lengI) : ans;
        count = 0;
        lengI = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if (count == 0) {
                ans = Math.max(ans, lengI);
                if (str[i] == '(') {
                    lengI = 0;
                    continue;
                }
            }
            lengI++;
            if (str[i] == ')') {
                count++;
            } else {
                count--;
            }
        }
        ans = count == 0 ? Math.max(ans, lengI) : ans;
        return ans;
    }

    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses1(s));
        System.out.println(longestValidParentheses2(s));
    }
}
