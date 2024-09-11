package com.company.practice.Graph_p;


import java.util.HashSet;
import java.util.Stack;

public class DFS_P {

    public static void dfs(Node_p node){
        Stack<Node_p> stack = new Stack<>();
        HashSet<Node_p> set = new HashSet<>();

        stack.push(node);
        set.add(node);
        System.out.println(node.value);

        while (!stack.isEmpty()){
            Node_p cur = stack.pop();
            for(Node_p next : cur.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

}
