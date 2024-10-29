package com.company.stack;

import java.util.Stack;

// 402 移掉K位数字
public class RemoveKdigits {
    public static String removeKdigits(String num, int k) {
        if(num.length() <= k){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        int index = 0;
        while(k > 0){
            if(stack.isEmpty() && chars[index] != '0'){
                stack.push(chars[index]);
            }else {
                while(!stack.isEmpty() && k > 0 && stack.peek() > chars[index]){
                    stack.pop();
                    k--;
                }
                if(!stack.isEmpty() || chars[index] != '0'){
                    stack.push(chars[index]);
                }
            }
            index++;
            if(index == chars.length){
                while(!stack.isEmpty() && k > 0){
                    stack.pop();
                    k--;
                }
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while(index < chars.length){
            if(sb.length() != 0 || chars[index] != '0'){
                sb.append(chars[index]);
            }
            index++;
        }
        if(sb.length() == 0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ans = removeKdigits("10001", 3);
        System.out.println(ans);
    }
}
