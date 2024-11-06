package com.company.Dp;

//lcy s1至少要删掉多少个字符才能变成s2的子串
// dp[i][j]，s1的前i个字符(0...i - 1)至少要删除多少个字符才能变成s2的前j个字符(0...j - 1)的子串
// s1[i - 1] == s2[j - 1]，则dp[i][j] = dp[i - 1][j - 1]
// s1[i - 1] != s2[j - 1], 则dp[i][j] = dp[i - 1][j] + 1;
// 返回m行的最小值即为答案
public class DeleteChar {
    public int DeleteNums(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j < n + 1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n + 1; j++){
            if(dp[m][j] < ans){
                ans = dp[m][j];
            }
        }
        return ans;
    }
}
