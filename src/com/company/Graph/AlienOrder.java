package com.company.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LCR 114 火星词典
public class AlienOrder {
    private Node[] nodes = new Node[26];
    public String alienOrder(String[] words) {
        //bulid
        for(String word : words){
            for (int i = 0; i < word.length(); i++) {
                if(nodes[word.charAt(i) - 'a'] == null){
                    nodes[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curWord = words[i];
            String nextWord = words[i + 1];
            int curWordLen = curWord.length();
            int nextWordLen = nextWord.length();
            int len = Math.min(curWordLen, nextWordLen);
            for (int j = 0; j < len; j++) {
                if(curWord.charAt(j) != nextWord.charAt(j)){
                    int curWordNodeIndex = curWord.charAt(j) - 'a';
                    int nextWordNodeIndex = nextWord.charAt(j) - 'a';
                    nodes[curWordNodeIndex].nexts.add(nodes[nextWordNodeIndex]);
                    nodes[nextWordNodeIndex].in++;
                    break;
                }
                if(j == len - 1 && curWordLen > nextWordLen){
                    return "";
                }
            }
        }

        //如果题目要求返回字典序最小的排列，改用priorityQueue即可，本题是自定义字典序，不需要
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        for (Node node : nodes) {
            if(node != null){
                count++;
                if(node.in == 0){
                    queue.add(node);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            sb.append(cur.val);
            for(Node next : cur.nexts){
                if(--next.in == 0){
                    queue.add(next);
                }
            }
        }
        return sb.length() == count ? sb.toString() : "";
    }

    class Node{
        public char val;
        public int in;
        public List<Node> nexts;

        public Node(char val) {
            this.val = val;
            in = 0;
            nexts = new ArrayList<>();
        }
    }
}
