package com.company.union;

//LCR 118 冗余连接
// 无向图是否有环可以使用并查集来判断
//本题中，满足条件的edges中最后出现的边其实就是第一个构成环的边，所以问题变成判读有环无环+提前返回
public class FindRedundantConnection {
    private int[] fathers;
    public int[] findRedundantConnection(int[][] edges) {
        fathers = new int[edges.length + 1];
        for (int i = 1; i < fathers.length; i++) {
            fathers[i] = i;
        }
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int iFather = findFather(i);
            int jFather = findFather(j);
            if(iFather != jFather){
                fathers[jFather] = iFather;
            }else {
                return new int[]{i, j};
            }
        }
        return null;
    }

    private int findFather(int i) {
        if(fathers[i] != i){
            fathers[i] = findFather(fathers[i]);
        }
        return fathers[i];
    }
}
