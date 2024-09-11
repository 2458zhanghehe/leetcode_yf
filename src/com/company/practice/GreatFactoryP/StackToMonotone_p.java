package com.company.practice.GreatFactoryP;

import java.util.Stack;

public class StackToMonotone_p {
    public static Stack<Integer> stackToMonotone(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (help.isEmpty()) {
                help.add(cur);
            } else {
                while (!help.isEmpty() && cur > help.peek()) {
                    int tmp = help.pop();
                    stack.add(tmp);
                }
                help.add(cur);
            }
        }
        while (!help.isEmpty()) {
            int tmp = help.pop();
            stack.add(tmp);
        }
        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(8);
        stack.add(12);
        stack.add(20);
        stack.add(2);
        stack = stackToMonotone(stack);
        for (Integer tmp : stack) {
            System.out.print(tmp + " ");
        }
    }
}
