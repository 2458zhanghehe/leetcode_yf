package com.company.practice.GreatFactoryP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//leetcode 1856 单调栈 + 前缀和
public class MaxSubArrToA_p {
    public static int MSAA(int[] arr) {
        long[] preSum = new long[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        long max = 0;
        HashMap<Integer, int[]> map = getarea(arr);
        for (int i = 0; i < arr.length; i++) {
            int L = map.get(i)[0];
            int R = map.get(i)[1];
            long sum = preSum[R - 1] - (L == -1 ? 0 : preSum[L]);
            max = Math.max(max, sum * arr[i]);
        }
        long mod = (long) 1e9 + 7;
        return (int) (max % mod);
    }

    public static HashMap<Integer, int[]> getarea(int[] arr) {
        HashMap<Integer, int[]> map = new HashMap<>();
        Stack<LinkedList<Integer>> stack = new Stack<>();  //从下往上递增
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            if (stack.isEmpty()) {
                list.add(i);
                stack.add(list);
                continue;
            }
            int peekvalue = arr[stack.peek().getFirst()];
            while (arr[i] < peekvalue) {
                list = stack.pop();
                while (!list.isEmpty()) {
                    int left = stack.isEmpty() ? -1 : stack.peek().getLast();
                    map.put(list.pop(), new int[]{left, i});
                }
                peekvalue = stack.isEmpty() ? Integer.MIN_VALUE : arr[stack.peek().getFirst()];
            }
            if (arr[i] == peekvalue) {
                list = stack.pop();
                list.add(i);
                stack.add(list);
            }
            if (arr[i] > peekvalue) {
                list.add(i);
                stack.add(list);
            }
        }
        while (!stack.isEmpty()) {
            LinkedList<Integer> list = stack.pop();
            while (!list.isEmpty()) {
                int left = stack.isEmpty() ? -1 : stack.peek().getLast();
                map.put(list.pop(), new int[]{left, arr.length});
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 4, 5, 3, 5};
//        HashMap<Integer,int[]> map = getarea(a);
//        for(Integer i : map.keySet()){
//            System.out.println("key: " + i + " value " + map.get(i)[0] + " " + map.get(i)[1]);
//        }
        System.out.println(MSAA(a));
    }
}
