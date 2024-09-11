package com.company.practice.Hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hailiang {

    public static class Node{
        public char c;
        public int count;
        public Node(char c,int count){
            this.c = c;
            this.count = count;
        }
    }


    public static class MyC implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o2.count - o1.count;
        }
    }

    public static void countChar(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char charAt = str.charAt(i);
            if(map.containsKey(charAt)){
                map.put(charAt,map.get(charAt) + 1);
            }else {
                map.put(charAt,1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new MyC());

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            Node cur = new Node(entry.getKey(),entry.getValue());
            pq.add(cur);
        }
        while (!pq.isEmpty()){
            Node cur = pq.poll();
            System.out.println(cur.c + ": " + cur.count);
        }
    }


    public static void main(String[] args) {

    }
}
