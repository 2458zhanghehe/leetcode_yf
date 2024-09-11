package com.company.stack;

import java.util.Stack;

//仅借助额外一个栈把给定栈变为单调
public class StackToMonotone {
    public static Stack<Integer> stackToMonotone(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        int tmp = 0;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            if (help.isEmpty()) {
                help.add(tmp);
            } else {
                while (!help.isEmpty() && tmp > help.peek()) {
                    int i = help.pop();
                    stack.add(i);
                }
                help.add(tmp);
            }
        }
        while (!help.isEmpty()) {
            tmp = help.pop();
            stack.add(tmp);
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(12);
        stack.add(8);
        stack.add(9);
        stack.add(1);
        stack.add(20);
        stack = stackToMonotone(stack);
        for (Integer tmp : stack) {
            System.out.println(tmp);
        }
    }
}
