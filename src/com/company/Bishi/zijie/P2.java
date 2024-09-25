package com.company.Bishi.zijie;

import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 节点数
        Map<Integer, Set<Integer>> graph = new HashMap<>();  // 邻接表表示树
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        // 读取 n-1 条边
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Set<String> additionalEdges = new HashSet<>();
        // 遍历每个节点 w 的邻居
        for (int w = 1; w <= n; w++) {
            List<Integer> neighbors = new ArrayList<>(graph.get(w));
            // 检查所有邻居节点对 (u, v)
            for (int i = 0; i < neighbors.size(); i++) {
                for (int j = i + 1; j < neighbors.size(); j++) {
                    int u = neighbors.get(i);
                    int v = neighbors.get(j);
                    // 如果 u 和 v 之间没有直接的边，则可以添加 (u, v)
                    if (!graph.get(u).contains(v)) {
                        // 为了避免 (u, v) 和 (v, u) 重复计数，我们总是保持 u < v
                        String edge = u < v ? u + "," + v : v + "," + u;
                        additionalEdges.add(edge);
                    }
                }
            }
        }
        // 输出可以添加的边的数量
        System.out.println(additionalEdges.size());
    }
}
