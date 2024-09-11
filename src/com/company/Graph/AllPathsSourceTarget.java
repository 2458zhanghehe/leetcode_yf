package com.company.Graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

// LCR110 所有可能的路径
public class AllPathsSourceTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        curList.add(0);
        process(graph, 0, curList, ansList);
        return ansList;
    }

    private static void process(int[][] graph, int curIndex, List<Integer> curList, List<List<Integer>> ansList) {
        if(curIndex == graph.length - 1){
            ArrayList<Integer> copy = new ArrayList<>(curList);
            ansList.add(copy);
        }

        int[] nexts = graph[curIndex];
        for(int next : nexts){
            if(!curList.contains(next)){
                curList.add(next);
                process(graph, next, curList, ansList);
                curList.remove(curList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(9);
        list.add(8);
        list.add(7);
        list.add(6);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
