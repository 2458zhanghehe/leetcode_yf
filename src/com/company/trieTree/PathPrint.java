package com.company.trieTree;

import java.util.TreeMap;

/*
* 给你一个字符串类型的数组arr，比如：
* String[] arr = ["b\\cst", "d\\", "a\\d\\e", "a\\b\\c"]
* 把目录结构打印出来，子目录直接列在父目录下面，并比父目录向右进两格，
* 要求同一级的需要按照字母顺序排序，eg：
* a
*   b
*     c
*   d
*     e
* b
*   cst
* d
* */
public class PathPrint {
    public static class Node{
        public String name;
        public TreeMap<String, Node> nextMap;
        public Node(String name){
            this.name = name;
            nextMap = new TreeMap<>();
        }
    }

    public static void pathPrint(String[] folderPaths){
        if(folderPaths == null || folderPaths.length == 0){
            return;
        }
        //根据字符串，把前缀树建立好，头节点为head
        Node head = generateFolderTree(folderPaths);

        //打印
        printProcess(head,0);
    }

    private static Node generateFolderTree(String[] folderPaths) {
        Node head = new Node("");
        for(String foldPath : folderPaths){
            //注意这里实际是对一个\进行划分，因为split方法里既支持转义又支持正则
            String[] paths = foldPath.split("\\\\");
            Node cur = head;
            for(int i = 0; i < paths.length; i++){
                if(!cur.nextMap.containsKey(paths[i])){
                    cur.nextMap.put(paths[i],new Node(paths[i]));
                }
                cur = cur.nextMap.get(paths[i]);
            }
        }
        return head;
    }

    //深度优先遍历
    private static void printProcess(Node node, int level){
        if(level != 0){
            System.out.println(get2nSpace(level) + node.name);
        }
        for(Node next : node.nextMap.values()){
            printProcess(next,level + 1);
        }
    }

    private static String get2nSpace(int level) {
        String res = "";
        for(int i = 1; i < level; i++){
            res += "  ";
        }
        return res;
    }
}
