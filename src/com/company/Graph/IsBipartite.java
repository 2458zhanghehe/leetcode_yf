package com.company.Graph;

// LCR 106 判断二分图 DFS或BFS + 染色
public class IsBipartite {
    private boolean res = true;
    private boolean[] color;
    private boolean[] visited;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        //有可能存在多个子图
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                //每个子图的第一个入图节点颜色都默认是false
                visited[i] = true;
                dfs(i, graph);
            }
        }
        return res;
    }

    private void dfs(int i, int[][] graph) {
        if (!res) {
            return;
        }

        for (int next : graph[i]) {
            if (!visited[next]) {
                color[next] = !color[i];
                visited[next] = true;
                dfs(next, graph);
            } else {
                if (color[next] == color[i]) {
                    res = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        IsBipartite isBipartite = new IsBipartite();
        //java的二位数组中每一行长度不一定相同
        int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        System.out.println(isBipartite.isBipartite(graph));
    }
}

