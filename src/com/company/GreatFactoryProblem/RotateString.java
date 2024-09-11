package com.company.GreatFactoryProblem;

//leetcode796
public class RotateString {
    public boolean rotateString(String str1, String str2){
        if(str2.length() != str1.length()){
            return false;
        }
        if(str1.length() == 1){
            return str1.equals(str2);
        }
        str1 = str1 + str1;
        return kmp(str1, str2);
    }

    private boolean kmp(String str1, String str2) {
        int[] next = getNext(str2.toCharArray());
        int i = 0;
        int j = 0;

        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            }else if(j > 0){
                j = next[j];
            }else {
                i++;
            }
        }

        return j == str2.length();
    }

    private int[] getNext(char[] chars) {
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;

        int i = 2;
        int cn = 0;
        while(i < chars.length){
            if(chars[cn] == chars[i - 1]){
                next[i] = cn + 1;
                i++;
                cn++;
            }else if(cn > 0){
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
