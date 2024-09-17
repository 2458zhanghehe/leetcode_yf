package com.company.Bishi.tuhu;

import com.company.Graph.Edge;

import java.util.ArrayList;
import java.util.List;

public class P2 {
    public int maxPoints (int n, int[] points, int[][] dependencies, int k) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(points[i]);
        }

        for (int[] dependency : dependencies) {
            Node from = nodes[dependency[1]];
            Node to = nodes[dependency[0]];
            from.nexts.add(to);
            to.in++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i].in == 0) {
                ans = Math.max(process(0, nodes[i], k), ans);
            }
        }
        return ans;
    }

    private int process(int index, Node curNode, int k) {
        if (index == k - 1) {
            return curNode.val;
        }
        int ans = 0;
        for (Node next : curNode.nexts) {
            next.in--;
            if (next.in == 0) {
                ans = Math.max(ans, process(index + 1, next, k));
            }
            next.in++;
        }
        return ans + curNode.val;
    }

    class Node {
        public int val;
        public int in;
        public List<Node> nexts;

        public Node(int val) {
            this.val = val;
            in = 0;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        P2 p2 = new P2();
        int[] nums = {8, 3, 7, 5, 6, 2};
        int[][] grids = {{1, 0}, {2, 1}, {3, 1}, {4, 2}};
        int ans = p2.maxPoints(6, nums, grids, 3);
        System.out.println(ans);
    }

}
