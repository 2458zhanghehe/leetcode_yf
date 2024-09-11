package com.company.Dp;



import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    //error
    public static boolean wordBreak(String s, List<String> wordDict) {
        int i = 0;
        while(i < s.length()){
            boolean no = true;
            for(int j = 0; j < wordDict.size(); j++){
                String cur = wordDict.get(j);
                if(s.startsWith(cur, i)){
                    no = false;
                    i = i + cur.length();
                    break;
                }
            }
            if(no){
                return false;
            }
        }
        return true;
    }


    public static boolean wordBreak2(String s, List<String> wordDict) {
        return process(s,wordDict,0, s.length());
    }

    private static boolean process(String s, List<String> wordDict, int index, int len) {
        if(index == len){
            return true;
        }
        for(String cur : wordDict){
            if(s.startsWith(cur, index)){
                boolean curB = process(s, wordDict, index + cur.length(), len);
                if(curB){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreak3(String s, List<String> wordDict) {
        int strLen = s.length();
        boolean[] dp = new boolean[strLen + 1];
        dp[strLen] = true;
        for(int i = strLen - 1; i >= 0; i--){
            for(String cur : wordDict){
                if(s.startsWith(cur, i)){
                    dp[i] = dp[i + cur.length()];
                    if(dp[i]){
                        break;
                    }
                }
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        String s = "catsandog";
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        wordBreak3(s,list);
    }
}
