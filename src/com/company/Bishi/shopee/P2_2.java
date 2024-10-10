package com.company.Bishi.shopee;

import java.util.*;

public class P2_2 {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public int find(int[] arr) {
        process(0, arr);
        return ans.size();
    }

    private void process(int cur, int[] arr) {
        if(path.size() > 1){
            ans.add(new ArrayList<>(path));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = cur; i < arr.length; i++) {
            if((!path.isEmpty() && path.getLast() > arr[i])){
                continue;
            }
            if(map.getOrDefault(arr[i], 0) >= 1){
                continue;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            path.add(arr[i]);
            process(i + 1, arr);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        P2 p2 = new P2();
        int[] arr1 = {4, 6, 7, 7};
        int ans = p2.find(arr1);
        System.out.println(ans);
    }
}
