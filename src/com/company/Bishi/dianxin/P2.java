package com.company.Bishi.dianxin;

import java.util.HashMap;
import java.util.Map;

public class P2 {
    public int countStr (String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(char cur : chars){
            if(cur == 'd' || cur == 'D'){
                map.put('d', map.getOrDefault('d', 0) + 1);
            }else if(cur == 'i' || cur == 'I'){
                map.put('i', map.getOrDefault('i', 0) + 1);
            }else if(cur == 'a' || cur == 'A'){
                map.put('a', map.getOrDefault('a', 0) + 1);
            }else if(cur == 'n' || cur == 'N'){
                map.put('n', map.getOrDefault('n', 0) + 1);
            }else if(cur == 'x' || cur == 'X'){
                map.put('x', map.getOrDefault('x', 0) + 1);
            }
        }

        int ans = Integer.MAX_VALUE;
        char[] targets = {'i', 'n', 'd', 'a', 'x'};
        for(char target : targets){
            Integer count = map.getOrDefault(target, 0);
            if(target == 'i' || target == 'n'){
                ans = Math.min(ans, count / 2);
            }else {
                ans = Math.min(ans, count);
            }
        }
        return ans;
    }
}
