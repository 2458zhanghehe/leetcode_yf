package com.company.Hash;

import java.util.HashMap;

 // leetcode 1 两数之和
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        // key:val  value:index
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                Integer index2 = map.get(target - nums[i]);
                if(index2 != i){
                    return new int[]{i,index2};
                }
            }
        }
        return null;
    }

}
