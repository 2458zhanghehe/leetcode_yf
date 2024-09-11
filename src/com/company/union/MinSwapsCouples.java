package com.company.union;

//leetcode765 左程云算法讲解056 并查集 上
public class MinSwapsCouples {

    private int[] father = new int[30];
    private int setNums;

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        build(n / 2);
        for(int i = 0; i < n; i += 2){
            union(row[i] / 2, row[i + 1] / 2);
        }
        return n / 2 - setNums;
    }

    private void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if(fx != fy){
            father[fx] = fy;
            setNums--;
        }
    }

    private int find(int i) {
        if(i != father[i]){
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private void build(int m){
        for(int i = 0; i < m; i++){
            father[i] = i;
        }
        setNums = m;
    }
}
