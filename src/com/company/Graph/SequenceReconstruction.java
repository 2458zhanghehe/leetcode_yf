package com.company.Graph;

import java.util.*;

//LCR 115 序列重建 重要 不太容易想到拓扑排序
public class SequenceReconstruction {
    public static boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        if(sequences.length == 1){
            return Arrays.equals(nums,sequences[0]);
        }
        Node[] nodes = new Node[10001];
        for(int[] sequence : sequences){
            for (int i = 0; i < sequence.length - 1; i++) {
                int from = sequence[i];
                int to = sequence[i + 1];
                if(nodes[from] == null || nodes[to] == null){
                    if(nodes[from] == null){
                        nodes[from] = new Node(from);
                    }
                    if(nodes[to] == null){
                        nodes[to] = new Node(to);
                    }
                    nodes[from].nexts.add(nodes[to]);
                    nodes[to].in++;
                }else {
                    if(!nodes[from].nexts.contains(nodes[to])){
                        nodes[from].nexts.add(nodes[to]);
                        nodes[to].in++;
                    }
                }
            }
        }

        Queue<Node> zeroQueue = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i] != null && nodes[i].in == 0){
                zeroQueue.add(nodes[i]);
                if(zeroQueue.size() > 1){
                    return false;
                }
            }
        }

        int index = 0;
        while(!zeroQueue.isEmpty()){
            Node cur = zeroQueue.poll();
            if(index == nums.length || cur.val != nums[index]){
                return false;
            }
            for(Node next : cur.nexts){
                if(--next.in == 0){
                    zeroQueue.add(next);
                }
                if(zeroQueue.size() > 1){
                    return false;
                }
            }
            index++;
        }
        return index == nums.length;
    }

    static class Node{
        public int in;
        public int val;
        public List<Node> nexts;
        public Node(int val){
            this.val = val;
            in = 0;
            nexts = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[][] sequences = {{1,2},{1,3},{2,3}};
        System.out.println(sequenceReconstruction(nums, sequences));
    }
}
