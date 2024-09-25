package com.company.union;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

//leetcode 2421 好路径的数目
public class NumOfGoodPath {

    private int[] father = new int[30001];
    private int[] cnt = new int[30001];
//    // 代表结点（一定是最大值的节点） 该集合最大值个数
//    private HashMap<Integer, Integer> cntMap = new HashMap<>();

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        build(vals);
        Arrays.sort(edges, (o1, o2) -> {
            return Math.max(vals[o1[0]], vals[o1[1]]) - Math.max(vals[o2[0]], vals[o2[1]]);
        });

        int ans = vals.length;
        for(int[] cur : edges){
            int curAns = union(cur[0], cur[1], vals);
            ans += curAns;
        }
        return ans;
    }

    private int union(int x, int y, int[] vals) {
        int fx = find(x);
        int fy = find(y);
        int curAns = 0;
        if(vals[fx] > vals[fy]){
            father[fy] = fx;
        }else if(vals[fx] < vals[fy]){
            father[fx] = fy;
        }else {
            curAns = cnt[fx] * cnt[fy];
            father[fy] = fx;
            cnt[fx] += cnt[fy];
        }
        return curAns;
    }

    private int find(int i) {
        if(i != father[i]){
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void build(int[] vals) {
        for(int i = 0; i < vals.length; i++){
            father[i] = i;
            cnt[i] = 1;
        }
    }
}
