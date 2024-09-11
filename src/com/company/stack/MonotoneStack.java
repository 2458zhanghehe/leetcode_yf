package com.company.stack;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

// leetcode 1856 左66
// 单调栈 从底往上递减，找左边最近比他大的，右边最近比他大的
// 栈中放的是index，之所以为List是为了防止出现重复值
public class MonotoneStack {
    public static HashMap<Integer, int[]> MS(int[] arr) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            if (stack.isEmpty()) {
                list.add(i);
                stack.add(list);
                continue;
            }

            int peekvalue = arr[stack.peek().getFirst()];
            while (arr[i] > peekvalue) {
                list = stack.pop();
                while (!list.isEmpty()) {
                    int left = stack.isEmpty() ? -1 : stack.peek().getLast();
                    map.put(list.pop(), new int[]{left, i});
                }
                peekvalue = stack.isEmpty() ? Integer.MAX_VALUE : arr[stack.peek().getFirst()];
            }

            if (arr[i] == peekvalue) {
                list = stack.pop();
                list.add(i);
                stack.add(list);
            }

            if (arr[i] < peekvalue) {
                list.add(i);
                stack.add(list);
            }

        }
        while (!stack.isEmpty()) {
            LinkedList<Integer> list = stack.pop();
            while (!list.isEmpty()) {
                int left = stack.isEmpty() ? -1 : stack.peek().getLast();
                map.put(list.pop(), new int[]{left, -1});
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 4, 5, 3, 5};
        HashMap<Integer, int[]> map = MS(arr);
        for (Integer i : map.keySet()) {
            System.out.println("key: " + i + " value: " + map.get(i)[0] + " " + map.get(i)[1]);
        }
    }
}
