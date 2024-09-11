package com.company.Dp;

//LCR 096  leetcode97 交错字符串
public class IsS1S2ToS3 {
    public boolean is_S1_S2ToS3(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        if(m == 0){
            return s2.equals(s3);
        }
        if(n == 0){
            return s1.equals(s3);
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i < m + 1; i++){
            if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                dp[i][0] = true;
            }else {
                break;
            }
        }
        for(int j = 1; j < n + 1; j++){
            if(s2.charAt(j - 1) == s3.charAt(j - 1)){
                dp[0][j] = true;
            }else {
                break;
            }
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
                            (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    //空间压缩
    public boolean is_S1_S2ToS3_2(String s1, String s2, String s3){
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()){
            return false;
        }
        if(m == 0){
            return s2.equals(s3);
        }
        if(n == 0){
            return s1.equals(s3);
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int j = 1; j < n + 1; j++){
            if(s2.charAt(j - 1) == s3.charAt(j - 1)){
                dp[j] = true;
            }else {
                break;
            }
        }

        boolean flag = true;
        for(int i = 1; i < m + 1; i++){
            if(flag){
                if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                    dp[0] = true;
                }else {
                    dp[0] = false;
                    flag = false;
                }
            }
            for(int j = 1; j < n + 1; j++){
                dp[j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j - 1]);
            }
        }
        return dp[n];
    }
}
