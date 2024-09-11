package com.company.practice;

//leetcode 28
public class KMP_p {
    public static int kmp_o(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[] next = getNext(chars2);

        int p1 = 0;
        int p2 = 0;

        while(p1 < chars1.length && p2 < chars2.length){
            if(chars1[p1] == chars2[p2]){
                p1++;
                p2++;
            }else if(next[p2] >= 0){
                p2 = next[p2];
            }else {
                p1++;
            }
        }
        return p2 == chars2.length ? p1 - p2 : -1;
    }

    private static int[] getNext(char[] chars2) {
        if(chars2.length == 1){
            return new int[]{-1};
        }
        int[] ans = new int[chars2.length];
        ans[0] = -1;
        ans[1] = 0;
        int cn = 0;
        int i = 2;
        while(i < chars2.length){
            if(chars2[i - 1] == chars2[cn]){
                ans[i++] = ++cn;
            }else if(cn == 0){
                ans[i++] = 0;
            }else {
                cn = ans[cn];
            }
        }
        return ans;
    }
}
