package com.company.recursionHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// leetcode 46 全排列
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> path = new ArrayList<>();
            path.add(nums[0]);
            list.add(path);
            return list;
        }
        process(nums, 0, list);
        return list;
    }

    private void process(int[] nums, int curIndex, List<List<Integer>> list) {
        if(curIndex == nums.length){
            ArrayList cur = new ArrayList<>();
            for(Integer num : nums){
                cur.add(num);
            }
            list.add(cur);
            return;
        }
        for (int i = curIndex; i < nums.length; i++) {
            swap(nums, curIndex, i);
            process(nums, curIndex + 1, list);
            swap(nums, curIndex, i);
        }
    }

    private void swap(int[] nums, int curIndex, int i) {
        int t = nums[curIndex];
        nums[curIndex] = nums[i];
        nums[i] = t;
    }
}
