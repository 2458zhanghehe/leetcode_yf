package com.company.Graph;

import java.util.*;


//leetcode 133
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        HashMap<Node,Node> hashMap = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();

        hashMap.put(node,new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            for(Node cur : tmp.neighbors){
                if(!hashMap.containsKey(cur)){
                    hashMap.put(cur,new Node(cur.val));
                    queue.add(cur);
                }
                hashMap.get(tmp).neighbors.add(hashMap.get(cur));
            }
        }
        return hashMap.get(node);
    }




    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = new ArrayList<Node>(Arrays.asList(node2,node4));
        node2.neighbors = new ArrayList<Node>(Arrays.asList(node1,node3));
        node3.neighbors = new ArrayList<Node>(Arrays.asList(node2,node4));
        node4.neighbors = new ArrayList<Node>(Arrays.asList(node1,node3));

//        cloneGraph(node1);
    }
}
