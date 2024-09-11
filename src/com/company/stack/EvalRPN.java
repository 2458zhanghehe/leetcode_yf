package com.company.stack;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//leetcode150
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String cur : tokens){
            try{
                Integer val = Integer.valueOf(cur);
                stack.add(val);
            }catch (Exception e){
                Integer b = stack.pop();
                Integer a = stack.pop();
                if("+".equals(cur)){
                    stack.add(a + b);
                }else if("-".equals(cur)){
                    stack.add(a - b);
                }else if("*".equals(cur)){
                    stack.add(a * b);
                }else if("/".equals(cur)){
                    stack.add(a / b);
                }else {
                    System.out.println("出错啦");
                }
            }
        }
        return stack.pop();
    }

    public static int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer b;
        Integer a;
        for(String cur : tokens){
            switch (cur){
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.add(a / b);
                    break;
                default:
                    Integer val = Integer.valueOf(cur);
                    stack.add(val);
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        evalRPN2(tokens);

//        String s = "123";
//        Integer val = Integer.valueOf(s);
//        System.out.println(val);
    }
}
