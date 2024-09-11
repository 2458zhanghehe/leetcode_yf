package com.company.recursionHuisu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//leetcode 39  组合总和  重要重要
public class CombinationSum {
    private static List<List<Integer>> ansList = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        process1(candidates, 0, target, new ArrayList<>());
        return ansList;
    }

    private static void process1(int[] arr, int index, int res, List<Integer> curList) {
        if (res == 0) {
            ArrayList<Integer> list = new ArrayList<>(curList);
            ansList.add(list);
            return;
        }
        if (res < 0 || index == arr.length) {
            return;
        }

        int preSize = curList.size();
        for (int i = 0; i < res / arr[index] + 1; i++) {

            /*需要带着累计容器对象遍历的问题
            * （1）每次遍历都新建一个list再传递，list = new ArrayList<Integer>(curList)
            * （2）使用一个list，但是遍历回来后，怎么加的元素要怎么减去，43-45行，另外，base处要新建list，否则存好的答案会被清空
            * 2用的更多，也更快*/

            for(int j = i; j > 0; j--){
                curList.add(arr[index]);
            }
            process1(arr, index + 1, res - arr[index] * i, curList);

            for(int j = i; j > 0; j--){
                curList.remove(preSize + j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = combinationSum(candidates, 7);
        System.out.println(lists.toString());
    }
}
