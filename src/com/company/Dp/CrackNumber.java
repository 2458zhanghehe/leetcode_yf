package com.company.Dp;

// LCR 165 解密数字 和lc 91很想，区别是0到25映射和1到26映射
//本题碰到0可以单独映射，不能05这样映射。91题是0既不能单独映射也不能05映射，只能10或20映射
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
        int ciphertext = 106;
        System.out.println(crackNumber(ciphertext));
    }
}
