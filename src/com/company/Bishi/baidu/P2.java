package com.company.Bishi.baidu;

import java.util.Scanner;
import java.util.Stack;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] xi = new int[m];
        for (int i = 0; i < m; i++) {
            xi[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        for (int i = 0; i < m; i++) {
            if(xi[i] < stack.peek()){
                stack.push(xi[i]);
            }else {
                while(!stack.isEmpty() && xi[i] >= stack.peek()){
                    stack.pop();
                }
                stack.push(xi[i]);
            }
            System.out.print(stack.size() + " ");
        }
    }
}
