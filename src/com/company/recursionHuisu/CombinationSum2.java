package com.company.recursionHuisu;

import java.util.*;

//leetcode 40 组合总和2
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ansList = new ArrayList<>();
        process(candidates, 0, target, new ArrayList<Integer>(), ansList);
        return ansList;
    }

    private void process(int[] candidates, int start, int rest, ArrayList<Integer> path, List<List<Integer>> ansList) {
        if(rest == 0){
            ansList.add(new ArrayList<>(path));
            return;
        }

        if(start >= candidates.length || rest < 0){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if(rest < candidates[i]){
                break;
            }
            if(i > start && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            process(candidates, i + 1, rest - candidates[i], path, ansList);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {2, 5, 2, 1, 2};
        System.out.println(combinationSum2.combinationSum2(candidates, 5));
    }
}
