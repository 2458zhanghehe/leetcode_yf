package com.company.Bishi.meituan;

import java.util.Arrays;

public class P1 {
//    public static int[] count(String str){
//        char[] chars = str.toCharArray();
//        int[] counts = new int[26];
//        for(char cur : chars){
//            counts[cur - 'a']++;
//        }
//        int[] ans = new int[chars.length];
//        for(int i = 0; i < chars.length; i++){
//            ans[i] = counts[chars[i] - 'a'];
//        }
//        return ans;
//    }

    public static int[] count(String str){
        char[] chars = str.toCharArray();
        int[] ans = new int[chars.length];
        char pre = chars[0];
        int i = 0;
        while(i < chars.length){
            int j = i + 1;
            int count = 1;
            while(j < chars.length && chars[j] == pre){
                count++;
                j++;
            }
            while(i < j){
                ans[i++] = count;
            }
            if(j < chars.length){
                pre = chars[j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabbbcaa";
        int[] count = count(str);
        System.out.println(Arrays.toString(count));
    }
}
