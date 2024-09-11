package com.company.Dp;


//leetcode 115 不同的子序列
/*
* 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，
* 结果需要对 109 + 7 取模。
* 左程云视频068更多二维动态规划 pad有记录
* */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = 1;
        }
        for(int j = 1; j < n + 1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                dp[i][j] += dp[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    //空间压缩
    //因为每次更新只需要上一行数据，所以其实两个一维数据就可以
    //因为只需要用到上一行该列和该列前一个值，所以可以改为从右往左更新，左边的就是上一行的值，进一步压缩为一个一维数据
    public int numDistinct2(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for(int i = 1; i < m + 1; i++){
            for(int j = n; j > 0; j--){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}
