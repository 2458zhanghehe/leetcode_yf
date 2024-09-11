package com.company.string;

public class PalindromeNum {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0;
        int j = str.length() - 1;
        while(i <= j){
            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }
}
