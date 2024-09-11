package com.company.BFS;

import java.util.*;

// 126 单词接龙Ⅱ
public class FindLadders {
    private static Node[] nodes = new Node[501];

    // key可以从values得到
    private static HashMap<String, List<String>> map;
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList = new ArrayList<>(wordList);
        if(!wordList.contains(endWord)){
            return new ArrayList<>();
        }

        nodes[0] = new Node(beginWord);

        //build
        map = new HashMap<>();
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
        HashSet<Node> curLevelSet = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[0]);
        set.add(nodes[0]);
        // 这里采用curLevelEnd标记一层的结束
        int curLevel = 1;
        Node curLevelEnd = nodes[0];
        Node nextLevelEnd = null;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    if(!curLevelSet.contains(next)){
                        queue.add(next);
                        curLevelSet.add(next);
                        nextLevelEnd = next;
                    }
                    List<String> list = map.getOrDefault(next.val, new ArrayList<>());
                    list.add(cur.val);
                    map.put(next.val, list);
                }
            }
            if(curLevelEnd == cur){
                curLevelEnd = nextLevelEnd;
                nextLevelEnd = null;
                curLevel++;
                set.addAll(curLevelSet);
                curLevelSet.clear();
            }
            if(endWord.equals(cur.val)){
                break;
            }
        }
        if(!map.containsKey(endWord)){
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(endWord);
        dfs(endWord, beginWord, res, list);
        return res;
    }


    //利用map进行dfs寻找路径
    private static void dfs(String curWord, String beginWord, List<List<String>> res, ArrayList<String> list) {
        if(curWord.equals(beginWord)){
            res.add(new ArrayList<>(list));
            return;
        }

        List<String> fromWords = map.get(curWord);
        for(String fromWord : fromWords){
            list.add(0,fromWord);
            dfs(fromWord, beginWord, res, list);
            list.remove(0);
        }
    }


    private static void union(int i, int j) {
        Node iNode = nodes[i];
        Node jNode = nodes[j];

        iNode.nexts.add(jNode);
        jNode.nexts.add(iNode);

    }

    private static boolean isNeghbour(String iWord, String jWord) {
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

    static class Node{
        public String val;
        public List<Node> nexts;
        public Node(String val) {
            this.val = val;
            nexts = new ArrayList<>();
        }
    }
    
    public static void main(String[] args) {
        String[] words = {"ted","tex","red","tax","tad","den","rex","pee"};
        List<String> wordList = Arrays.asList(words);
        String beginWord = "red";
        String endWord = "tax";
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
