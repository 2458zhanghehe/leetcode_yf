package com.company.stack;

import java.util.Stack;

//leetcode71
public class SimplifyPath {
    public String simplifyPath(String path) {

        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : split) {
            if (".".equals(s) || "/".equals(s) || "".equals(s)) {
                continue;
            } else if ("..".equals(s)) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.add(s);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            String cur = stack.pop();
            stringBuilder.insert(0, cur);
            stringBuilder.insert(0, "/");
        }
        return stringBuilder.toString();
    }
}
