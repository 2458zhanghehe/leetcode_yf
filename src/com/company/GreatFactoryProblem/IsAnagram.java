package com.company.GreatFactoryProblem;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] cntS = new int[26];
        int[] cntT = new int[26];

//        char[] sChar = s.toCharArray();
//        char[] tChar = t.toCharArray();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            cntS[sChar - 'a']++;
            char tChar = t.charAt(i);
            cntT[tChar - 'a']++;
        }

        return Arrays.equals(cntS,cntT);
    }

}
