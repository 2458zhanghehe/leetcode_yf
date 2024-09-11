package com.company.GreatFactoryProblem;

import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if(pattern.length() !=  ss.length){
            return false;
        }
        HashMap<Character, String> hashMap = new HashMap<>();
        for(int i = 0; i < ss.length; i++){
            char pChar = pattern.charAt(i);
            if(!hashMap.containsKey(pChar)){
                if(hashMap.containsValue(ss[i])){
                    return false;
                }
                hashMap.put(pChar,ss[i]);
            }else {
                String s1 = hashMap.get(pChar);
                if(!ss[i].equals(s1)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "a apple is good";
        wordPattern(null,s);
    }
}
