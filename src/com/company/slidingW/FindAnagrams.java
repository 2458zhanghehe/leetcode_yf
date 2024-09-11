package com.company.slidingW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 438 找到字符串中所有字母异位词
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {

        int pLen = p.length();
        int[] cnt_P = new int[26];

        for (int i = 0; i < pLen; i++) {
            cnt_P[p.charAt(i) - 'a']++;
        }
        int debat = pLen;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int l = 0, r = 0; r < s.length(); ){
            int index = s.charAt(r) - 'a';
            if(cnt_P[index] > 0){
                   debat--;
                   cnt_P[index]--;
                   r++;
            }else {
                //本来想利用lastIndex记录上一次位置，l多收缩，但是字符x可能出现多次，
                // lastindex更新时机无法确定，如果p中无重复字符，可以使用lastIndex
                cnt_P[s.charAt(l++) - 'a']++;
                debat++;
            }
            if(debat == 0){
                ans.add(l);
                cnt_P[s.charAt(l++) - 'a']++;
                debat = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams("abcabccbbaa", "aabbcc");
        System.out.println(ans.toString());
    }
}
