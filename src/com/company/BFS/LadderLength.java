package com.company.BFS;


import java.util.*;

//leecode 127 单词接龙
public class LadderLength {
    private Node[] nodes = new Node[5001];
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)){
            return 0;
        }

        nodes[0] = new Node(beginWord);

        //build
        for (int i = 0; i < wordList.size(); ) {
            String curStr = wordList.get(i);
            if(beginWord.equals(curStr)){
                wordList.remove(i);
            }else {
                nodes[++i] = new Node(curStr);
            }
        }

        //union
        for (int i = 0; i < wordList.size(); i++) {
            if(isNeghbour(beginWord, wordList.get(i))){
                union(0, i + 1);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            String iWord = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String jWord = wordList.get(j);
                if(isNeghbour(iWord, jWord)){
                    union(i + 1,j + 1);
                }
            }
        }

        //BFS
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[0]);
        set.add(nodes[0]);
        // 这里采用curLevelEnd标记一层的结束
        int curLevel = 1;
        Node curLevelEnd = nodes[0];
        Node nextLevelEnd = null;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(endWord.equals(cur.val)){
                return curLevel;
            }
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    queue.add(next);
                    set.add(next);
                    nextLevelEnd = next;
                }
            }
            if(curLevelEnd == cur){
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
                curLevel++;
            }
        }
        return 0;
    }


    private void union(int i, int j) {
        Node iNode = nodes[i];
        Node jNode = nodes[j];

        iNode.nexts.add(jNode);
        jNode.nexts.add(iNode);

    }

    private boolean isNeghbour(String iWord, String jWord) {
        int diff = 0;
        //题目给定二者长度相等
        for (int i = 0; i < iWord.length(); i++) {
            if(iWord.charAt(i) != jWord.charAt(i)){
                diff++;
            }
            if(diff > 1){
                return false;
            }
        }
        return true;
    }

    class Node{
        public String val;
        public List<Node> nexts;
        public Node(String val) {
            this.val = val;
            nexts = new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        String[] str = {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};
        // 将str转为list
        List<String> wordList = stringArrayToList(str);

        String beginWord = "ymain";
        String endWord = "oecij";
        LadderLength ladderLength = new LadderLength();
        System.out.println(ladderLength.ladderLength(beginWord, endWord, wordList));
        Queue<String> queue = new LinkedList<>();
    }

    private static List<String> stringArrayToList(String[] str) {
        List<String> list = new ArrayList<>();
        for (String s : str) {
            list.add(s);
        }
        return list;
    }
}
