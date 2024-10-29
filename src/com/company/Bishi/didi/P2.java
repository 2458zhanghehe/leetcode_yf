package com.company.Bishi.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {

    private static int[] parent;
    private  static int[] size;
    private  static  boolean[] added;
    private static int components;

    private static void initialize(int n){
        parent = new int[n + 1];
        size = new int[n + 1];
        added = new boolean[n + 1];
        components = 0;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            if(size[rootX] < size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            components--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.add(new int[]{u,v});
        }
        initialize(n);

        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int currentNode = i + 1;
            added[currentNode] = true;
            components++;

            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                if((u == currentNode && added[v]) || (v == currentNode && added[u])){
                    union(u,v);
                }
            }
            result[i] = components;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
