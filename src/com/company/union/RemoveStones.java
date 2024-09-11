package com.company.union;

import java.util.HashMap;

// leetcode 947 移除最多的同行或同列石头  左程云057 并查集下
public class RemoveStones {
    private int[] father = new int[1000];
    private int setNUms;

    public int removeStones(int[][] stones) {
        //row_index stone_id
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        //col_index stone_id
        HashMap<Integer, Integer> colMap = new HashMap<>();
        int n = stones.length;
        build(n);
        for(int i = 0; i < n; i++){
            int[] stone = stones[i];
            if(!rowMap.containsKey(stone[0])){
                rowMap.put(stone[0], i);
            }else {
                union(i,rowMap.get(stone[0]));
            }

            if(!colMap.containsKey(stone[1])){
                colMap.put(stone[1], i);
            }else {
                union(i,colMap.get(stone[1]));
            }
        }
        return n - setNUms;
    }

    private void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if(x != y){
            father[x] = y;
            setNUms--;
        }
    }

    private int find(int i) {
        if(i != father[i]){
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void build(int length) {
        for(int i = 0; i < length; i++){
            father[i] = i;
        }
        setNUms = length;
    }
}
