package com.company.Dp;

//leetcode 72 编辑距离
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int ans = editDistance(word1, word2, 1, 1, 1);
        return ans;
    }

    //dp[i][j]表示将word1的前i个字符(0...i - 1)转为word2的前j个字符(0...j - 1)的最小代价
    //(1) word1[i - 1]参与，
    // 1° word1[i - 1]变为word2[j - 1]，则 word1[i - 1] == word2[j - 1] ? dp[i - 1][j - 1] : (dp[i - 1][j - 1] + c)不等于则替换
    // 2° word1[i - 1]变为word2[j - 1]之前的字符，则dp[i][j - 1] + a，插入一个
    //(2) word1[i - 1]不参与， 则dp[i - 1][j] + b，删除一个

    private static int editDistance(String word1, String word2, int a, int b, int c) {
        c = Math.min(c, a + b);
        char[] w1Chars = word1.toCharArray();
        char[] w2Chars = word2.toCharArray();
        int m = w1Chars.length;
        int n = w2Chars.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            dp[i][0] = i * b;
        }
        for(int j = 1; j < n + 1; j++){
            dp[0][j] = j * a;
        }
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                int p1;
                if(w1Chars[i - 1] == w2Chars[j - 1]){
                    p1 = dp[i - 1][j - 1];
                }else {
                    p1 = dp[i - 1][j - 1] + c;
                }
                int p2 = dp[i][j - 1] + a;
                int p3 = dp[i - 1][j] + b;
                dp[i][j] = Math.min(p1,Math.min(p2,p3));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        minDistance(word1, word2);
    }
}
