package com.company.Hash;

import java.util.HashMap;

// leetcode 953 验证外星语词典
public class IsAlienSorted {
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String pre = words[i];
            String later = words[i + 1];
            int index = 0;
            boolean AllPreSame = true;
            while (index < pre.length() && index < later.length()) {
                if (pre.charAt(index) == later.charAt(index)) {
                    index++;
                } else if (orderMap.get(pre.charAt(index)) < orderMap.get(later.charAt(index))) {
                    AllPreSame = false;
                    break;
                } else {
                    return false;
                }
            }
            if(AllPreSame && pre.length() > later.length()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
}
