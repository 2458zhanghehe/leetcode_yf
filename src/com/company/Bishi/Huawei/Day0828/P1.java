package com.company.Bishi.Huawei.Day0828;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//老鼠串门
//这里假设整体按编号进洞了，如果无序，可维护一个set存放进洞/栈编号
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ansList = new ArrayList<>();
        for(int cur : nums){
            if(stack.isEmpty()){
                stack.push(cur);
                continue;
            }
            while(!stack.isEmpty() && cur <= stack.peek()){
                ansList.add(stack.pop());
            }
            stack.push(cur);
        }

        while(!stack.isEmpty()){
            ansList.add(stack.pop());
        }
        System.out.println(ansList);
    }
}
