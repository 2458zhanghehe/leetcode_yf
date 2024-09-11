package com.company.GreatFactoryProblem;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        //num cnt
        HashMap<Integer, Integer> hasmap = new HashMap<>();

        for(int i : nums){
            hasmap.put(i,hasmap.getOrDefault(i,0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = hasmap.entrySet();

        Integer best = null;
        Integer cnt = null;
        for(Map.Entry<Integer,Integer> entry : entries){
            if(best == null){
                best = entry.getKey();
                cnt = entry.getValue();
            }else {
                if(entry.getValue() > cnt){
                    best = entry.getKey();
                    cnt = entry.getValue();
                }
            }
        }
        return best;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length >> 1;
        return nums[mid];
    }

    //摩尔投票法
    public int majorityElement3(int[] nums) {
        int x = nums[0];
        int vote = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == x){
                vote++;
            }else {
                vote--;
            }

            if(vote == 0){
                x = nums[i + 1];  //不用判断边界，nums-1位置投完票后vote不可能为0
            }
        }
        return x;
    }
}
