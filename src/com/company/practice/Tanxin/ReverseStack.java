package com.company.practice.Tanxin;

import java.util.Stack;

public class ReverseStack {
    public static void RS(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int tmp = process(stack);
        RS(stack);
        stack.push(tmp);
    }

    public static int process(Stack<Integer> stack) {
        int tmp = stack.pop();
        if (stack.isEmpty()) {
            return tmp;
        } else {
            int last = process(stack);
            stack.push(tmp);
            return last;
        }


    }
}
