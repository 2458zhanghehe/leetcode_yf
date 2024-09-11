package com.company.Bishi.Huawei.Day0417;

import java.util.Scanner;
import java.util.Stack;

public class P1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] splits = str.split(" ");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(splits[i]);
            int size = stack.size();
            if(size >= 3 && stack.get(size - 1).equals(stack.get(size - 2)) &&
                    stack.get(size - 2).equals(stack.get(size - 3))){
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            System.out.println(0);
        }else {
            print(stack);
        }
    }

    private static void print(Stack<String> stack) {
        if(stack.isEmpty()){
            return;
        }
        String cur = stack.pop();
        print(stack);
        System.out.print(cur + " ");
    }
}
