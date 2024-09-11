package com.company.union;

//lcr 116 省份数量
public class FindCircleNumber {
    private int[] fathers;
    private int size;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        size = n;
        fathers = new int[n + 1];
        build();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(isConnected[i][j] == 1){
                    union(isConnected, i, j);
                }
            }
        }
        return size;
    }

    private int findFather(int i){
        if(fathers[i] != i){
            fathers[i] = findFather(fathers[i]);
        }
        return fathers[i];
    }

    private void union(int[][] isConnected, int i, int j) {
        int fi = findFather(i);
        int fj = findFather(j);
        if(fi != fj){
            size--;
            fathers[fj] = fi;
        }
    }

    private void build() {
        for (int i = 0; i <= size; i++) {
            fathers[i] = i;
        }
    }
}
