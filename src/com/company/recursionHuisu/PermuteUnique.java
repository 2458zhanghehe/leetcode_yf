package com.company.recursionHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

// leetcode 47 全排列2
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> path = new ArrayList<>();
            path.add(nums[0]);
            list.add(path);
            return list;
        }
        Arrays.sort(nums);
        process2(nums, 0, list);
        List<List<Integer>> dlist = list.stream().distinct().collect(Collectors.toList());
        return dlist;
    }

    private void process1(int[] nums, int curIndex, List<List<Integer>> list) {
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
            process1(nums, curIndex + 1, list);
            swap(nums, curIndex, i);
        }
    }

    private void process2(int[] nums, int curIndex, List<List<Integer>> list) {
        if(curIndex == nums.length){
            ArrayList cur = new ArrayList<>();
            for(Integer num : nums){
                cur.add(num);
            }
            list.add(cur);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = curIndex; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            swap(nums, curIndex, i);
            process2(nums, curIndex + 1, list);
            swap(nums, curIndex, i);
        }
    }

    private void swap(int[] nums, int curIndex, int i) {
        int t = nums[curIndex];
        nums[curIndex] = nums[i];
        nums[i] = t;
    }


}
