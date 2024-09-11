package com.company.GreatFactoryProblem;

import java.util.ArrayList;
import java.util.List;

//leetcode 228
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        if(nums.length == 1){
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int L = 0;
        int R = 0;
        ArrayList<String> result = new ArrayList<>();

        while(R < nums.length){
            if(R < nums.length - 1 && nums[R + 1] - nums[L] == R + 1 - L){
                R++;
            }else {
                if(L == R){
                    result.add(String.valueOf(nums[L]));
                }else {
                    result.add(String.valueOf(nums[L]) + "->" + String.valueOf(nums[R]));
                }
                L = R + 1;
                R = R + 1;
            }
        }
        return result;
    }
}
