package com.company.Dp;

// LCR 165 解密数字
public class CrackNumber {
    public static int crackNumber(int ciphertext) {
        String str = String.valueOf(ciphertext);
        int len = str.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1];
            if(i - 2 >= 0 && (str.charAt(i - 2) == '1' ||  (str.charAt(i - 2) == '2' && str.charAt(i - 1) <= '5'))){
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int ciphertext = 216612;
        crackNumber(ciphertext);
    }
}
