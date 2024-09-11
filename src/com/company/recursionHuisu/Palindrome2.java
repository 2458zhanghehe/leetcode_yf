package com.company.recursionHuisu;

//leetcode 132 分割回文串II
public class Palindrome2 {

    //超时
    public static int minCut(String s) {
        return process(s, 0);
    }

    private static int process(String s, int start) {
        if(start >= s.length() - 1){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s, start, i)){
                ans = Math.min(ans, i == s.length() - 1 ? 0 : process(s, i + 1) + 1);
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "bb";
        System.out.println(minCut(str));
    }
}
