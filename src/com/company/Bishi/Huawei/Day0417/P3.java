package com.company.Bishi.Huawei.Day0417;

import java.util.*;
/* 云上故障逃生
    在云上多个业务节点之间选择最快的逃生节点集，并考虑每个节点的剩余业务容量。有一个网络时延表，
    表示每个节点到其他节点的通信延迟；还有一个剩余业务容量表，表示每个节点的剩余业务容量。在一
    个节点故障时，需要选择一个或多个逃生节点，确保逃生路径的时延最小，并且逃生节点集各节点剩余
    容量的总和足够容纳故障节点的业务量，当故障节点与多个节点最短距离相同，优先选择编号较小的节
    点容灾，如果逃生节点集中多个节点最短距离相同时按编号从小到大的顺序排列。
    输入：
    第1行n表示云上业务节点数， 2<=n<=10000，节点编号从 0 开始，依次递增；
    第2到1+n行表示业务节点间的网络时延矩阵表 delayMatrix，delayMatrix[i][j] 表示节点 i 到节点 j 的通信时延;
    1）如果节点 i 和节点 j 之间没有直接相连的边，则 delayMatrix[i][j] 为 -1，第i个节点和它自己也没有边，所以delayMatrix[i][i]=-1
    2）节点间有边时延范围为 1<=�����������[�][�]<=10001<=delayMatrix[i][j]<=1000，矩阵元素间使用空格分割
    另，输入保证 delayMatrix[i][j] == delayMatrix[j][i]
    第2+n行表示各业务节点的剩余容量表 remainingCapacity，其中 remainingCapacity[i] 表示节点 i 的剩余业务容量，业
    务量的范围1<=�����������������[�]<=1001<=remainingCapacity[i]<=100，数组元素间使用空格分割；
    第3+n行表示故障业务节点编号 faultyNode，表示发生故障的节点，取值范围为 0<=����������<=�−10<=faultyNode<=n−1 ；
    第4+n行表示受损业务节点需要迁移的业务量, 受损业务量的范围 (0−1000](0−1000] 。

    输出：
    返回符合条件的逃生路径节点编号列表（以单空格间隔），当所有节点都不够故障节点业务容灾的时候输出所有容灾节点。
    样例：
    输入：
4
-1 5 -1 8
5 -1 1 3
-1 1 -1 4
8 3 4 -1
10 20 15 25
2
12
    输出：
    1
* */
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //bulid Node
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int cur = sc.nextInt();
                if(cur != -1){
                    Edge edge = new Edge(cur, nodes[i], nodes[j]);
                    nodes[i].nexts.add(nodes[j]);
                    nodes[i].edges.add(edge);
                    nodes[i].out++;
                    nodes[j].in++;
                }
            }
        }

        int[] capacity = new int[n];
        for(int i = 0; i < n; i++){
            capacity[i] = sc.nextInt();
        }
        int faultNode = sc.nextInt();
        int errorNum = sc.nextInt();

        //Dijkstra
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>();
        distanceMap.put(nodes[faultNode], 0);
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while(minNode != null){
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                Integer preD = distanceMap.getOrDefault(toNode, Integer.MAX_VALUE);
                distanceMap.put(toNode, Math.min(preD, distance + edge.weight));
            }

            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        }

        int[][] sorted = new int[n - 1][2];
        int cur = 0;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            int curNodeIndex = entry.getKey().value;
            Integer curDist = entry.getValue();
            if(curNodeIndex != faultNode){
                sorted[cur][0] = curNodeIndex;
                sorted[cur][1] = curDist;
                cur++;
            }
        }
        Arrays.sort(sorted, (o1, o2) -> (o1[1] == o2[1]) ? (o1[0] - o2[0]) : (o1[1] - o2[1]));

        cur = 0;
        while(errorNum > 0 && cur < n - 1){
            int curNodeIndex = sorted[cur][0];
            System.out.print(curNodeIndex + " ");
            errorNum -= capacity[curNodeIndex];
            cur++;
        }
    }

    private static Node getMinDistanceAndUnselectedNode(
            HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {

        Node minNode = null;
        int mindistance = Integer.MAX_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!selectedNodes.contains(node) && distance < mindistance){
                minNode = node;
                mindistance = distance;
            }
        }
        return minNode;
    }

    static class Node{
        public int value;
        public int in;  //入度
        public int out; //出度
        public ArrayList<Node> nexts;
        public ArrayList<Edge> edges;

        public Node(int value){
            this.value = value;
            in = 0;
            out = 0;
            nexts = new ArrayList<>();
            edges = new ArrayList<>();
        }
    }

    static class Edge{
        public int weight;
        public Node from;
        public Node to;

        public Edge(int weight, Node from, Node to){
            this.weight = weight;
            this.from = from;
            this.to = to;
        }
    }
}
