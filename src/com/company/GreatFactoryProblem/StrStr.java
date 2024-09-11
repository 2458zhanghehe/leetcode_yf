package com.company.GreatFactoryProblem;

//leetcode 28 常规解法，时间复杂度O(M*N)，优化即KMP算法
public class StrStr {
    public static int strStr(String haystack, String needle) {
        int p1 = 0;
        int p2 = 0;

        while(p1 < haystack.length()){
            if(haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
            }else {
                p1 = p1 - p2 + 1;
                p2 = 0;
            }
            if(p2 == needle.length()){
                return p1 - p2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
        System.out.println(strStr(haystack,needle));
    }
}
