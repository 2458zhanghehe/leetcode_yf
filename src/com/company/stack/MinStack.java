package com.company.stack;

import java.util.Stack;

//leetcode155 最小栈
class MinStack {
    private Stack<Integer> valStack;
    private Stack<Integer> minStack;

    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();

    }
    
    public void push(int val) {
        valStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        Integer cur = valStack.pop();
        if(cur.equals(minStack.peek())){
            minStack.pop();
        }
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}