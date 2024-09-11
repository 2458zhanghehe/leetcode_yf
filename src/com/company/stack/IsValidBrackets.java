package com.company.stack;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

//leetcode 20 有限括号
public class IsValidBrackets {
    public static boolean isValid(String s) {

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('{','}');
        hashMap.put('[',']');

        Stack<Character> stack = new Stack<>();
        for(Character cur : s.toCharArray()){
            if(hashMap.containsKey(cur)){
                //stack添加一律用push 不然显得不专业
                stack.push(cur);
                //stack.add(cur);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                if(!hashMap.get(stack.pop()).equals(cur)){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }


//    private char getValue(char ch){
//        switch (ch){
//            case '(': return ')';
//            case '[': return ']';
//            case '{': return '}';
//            default: return '.';
//        }
//    }


    public static void main(String[] args) {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
