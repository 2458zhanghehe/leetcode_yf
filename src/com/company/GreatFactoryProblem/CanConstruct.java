package com.company.GreatFactoryProblem;

import java.util.HashMap;

//leetcode 383
//简化：题目约束为小写英文字母，所以可以用数组写；
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        // char, nums
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++){
            char c = magazine.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        for(int i =0; i < ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }
            if(map.get(c) == 0){
                return false;
            }
            map.put(c,map.get(c) - 1);
        }
        return true;
    }
}
