package com.company.GreatFactoryProblem;

//leetcode 14
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int len = 0;

        while(true){
            if(len >= strs[0].length()){
                return len > 0 ? strs[0].substring(0,len) : "";
            }
            char ch = strs[0].charAt(len);
            for(int i = 1; i < strs.length; i++){
                if(len >= strs[i].length() || strs[i].charAt(len) != ch){
                    return len > 0 ? strs[0].substring(0,len) : "";
                }
            }
            len++;
        }
    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String ans = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            for(; j < ans.length() && j < strs[i].length(); j++){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if(ans.equals("")){
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","alow","flight"};
        System.out.println(longestCommonPrefix(strs));

        String s = "abcd";
        String substring = s.substring(0, 3);
        System.out.println(substring);
    }
}
