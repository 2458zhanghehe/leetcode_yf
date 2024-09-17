package com.company.Dp;

//leetcode 72 编辑距离
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int ans = editDistance(word1, word2, 1, 1, 1);
        return ans;
    }

    private static int editDistance(String word1, String word2, int a, int b, int c) {
        c = Math.min(c,a + b);
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
