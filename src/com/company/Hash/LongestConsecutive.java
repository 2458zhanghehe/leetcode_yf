package com.company.Hash;

import java.util.HashSet;

//leetcode128 最长连续序列
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        //重要！ HashSet也是哈希表，增删改查操作时间复杂度也为O(1)
        HashSet<Integer> set = new HashSet<>();
        for(int cur : nums){
            set.add(cur);
        }
        int ans = 0;
        for(Integer cur : set){
            if(!set.contains(cur - 1)){
                int len = 1;
                while(set.contains(++cur)){
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }
}
