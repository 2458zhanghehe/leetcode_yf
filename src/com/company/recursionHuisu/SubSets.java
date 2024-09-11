package com.company.recursionHuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode 78 子集
public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> curList = new ArrayList<>();
        List<List<Integer>> ansList = new ArrayList<>();
        process(nums, 0, ansList, curList, nums.length);
        return ansList;
    }

    //如果返回的是个数，则可以用dp
    //一个比较蛮烦的问题，返回的是个数，则需要考虑用dp
    //返回的是List,Array则不用考虑
    private static void process(int[] nums, int index, List<List<Integer>> ansList, List<Integer> curList, int len) {
        if(index == len){
            //新copy一个list出来
            ansList.add(new ArrayList<>(curList));
            return;
        }

        //不要
        process(nums, index + 1, ansList, curList, len);

        //要
        curList.add(nums[index]);
        process(nums, index + 1, ansList, curList, len);
        curList.remove(curList.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
}
