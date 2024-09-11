package com.company.stack;

import java.util.Stack;
//递归实现逆序一个栈  需要两个递归
public class ReverseStack {


    //获得栈底元素并移除
    public static int getBottom(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }
        int bottom = getBottom(stack);
        stack.push(result);
        return bottom;
    }

    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int bottom = getBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(4);
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
