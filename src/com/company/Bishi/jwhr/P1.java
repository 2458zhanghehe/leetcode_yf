package com.company.Bishi.jwhr;

import java.util.HashMap;
import java.util.Stack;

public class P1 {
    public static boolean isValidKuoHao(String str){
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();

        for(Character cur : str.toCharArray()){
            if(map.containsKey(cur)){
                stack.push(cur);
            }else {
                Character pop = stack.pop();
                if(map.get(pop) != cur){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "({)}";
        System.out.println(isValidKuoHao(str));
    }
}
