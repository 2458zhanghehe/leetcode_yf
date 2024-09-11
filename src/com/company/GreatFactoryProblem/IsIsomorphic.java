package com.company.GreatFactoryProblem;

import java.util.HashMap;

//leetcode205
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        // source yinshe
        HashMap<Character, Character> hashMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(hashMap.containsKey(sChar)){
                Character c = hashMap.get(sChar);
                if(!c.equals(tChar)){
                    return false;
                }
            }else {
                if(hashMap.containsValue(tChar)){
                    return false;
                }
                hashMap.put(sChar,tChar);
            }
        }
        return true;
    }
}
