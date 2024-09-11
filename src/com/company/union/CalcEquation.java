package com.company.union;

import java.util.HashMap;
import java.util.List;

//leetcode 399  重要 官方题解
public class CalcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //1构建并查集
        int equationsSize = equations.size();
        UnionFind unionFind = new UnionFind(2*equationsSize);
        HashMap<String, Integer> hashMap = new HashMap<>(2*equationsSize);
        int id = 0;
        for(int i = 0; i < equationsSize; i++){
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if(!hashMap.containsKey(var1)){
                hashMap.put(var1,id);
                id++;
            }

            if(!hashMap.containsKey(var2)){
                hashMap.put(var2,id);
                id++;
            }

            unionFind.union(hashMap.get(var1),hashMap.get(var2),values[i]);
        }

        //2 做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for(int i = 0; i < queriesSize; i++){
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if(id1 == null || id2 == null){
                res[i] = -1.0d;
            }else {
                res[i] = unionFind.isConnected(id1,id2);
            }
        }
        return res;
    }

    private class UnionFind{

        private int[] parent;

        //带权重的并查集   本题权重关系 i = weight[i] * parent[i]
        private double[] weight;

        public UnionFind(int n){
            this.parent = new int[n];
            this.weight = new double[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(int x, int y, double value){   //var(x)/var(y) = value
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = weight[y]*value/weight[x];
        }

        public int find(int x){
            if(x != parent[x]){
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            //find函数保证了树高只有2，如果根不一样，说明算不出来
            if(rootX == rootY){
                return weight[x]/weight[y];
            }else {
                return -1.0d;
            }
        }
    }
}
