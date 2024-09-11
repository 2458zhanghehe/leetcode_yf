package com.company.Dp;

//leetcode 1143 最长公共子序列
public class LongestCommonSubsequence {

    /*dp[i][j]的意义：text1的前i个字符text1[0...i - 1]，和text2[0...j - 1]的前j个字符的最长公共子序列
    (1) 要text1[i - 1]  1° text1[i - 1] == text2[j - 1]
                        则 text1[i - 1]可以和text2[j - 1]对应，也就是dp[i][j] = dp[i - 1][j - 1] + 1;
                        也可以选择不对应，也就是text1[i - 1]要和text2[j - 1]之前的对应，也就是dp[i][j] = dp[i][j - 1]
                        2° text1[i - 1] != text2[j - 1],
                        则text1[i - 1]只能和text2[j - 1]之前的某个字符对应，也就是dp[i][j] = dp[i][j - 1];
    (2) 不要text1[i - 1], 则dp[i][j] = dp[i - 1][j];
    转移方程： p1 = text1[i - 1] == text2[j - 1] ? Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]) : dp[i][j - 1];
            dp[i][j] = Math.max(p1, dp[i - 1][j])
    */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = text1.charAt(i - 1) == text2.charAt(j - 1) ? Math.max(dp[i - 1][j - 1] + 1, dp[i][j - 1]) : dp[i][j - 1];
                dp[i][j] = Math.max(dp[i - 1][j], tmp);
            }
        }
        return dp[m][n];
    }
}
