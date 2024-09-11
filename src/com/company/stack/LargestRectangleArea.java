package com.company.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// lc 84 柱状图中最大的举矩形
// 枚举高度 + 单调栈  重要
public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        Stack<LinkedList<Integer>> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
                continue;
            }

            int peekValue =heights[stack.peek().getLast()];
            while(!stack.isEmpty() && heights[i] < peekValue){
                LinkedList<Integer> curList = stack.pop();
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek().getLast();
                for(int index : curList){
                    //以heights[i]为高度能构成的矩形的宽就是right - left - 1
                    ans = Math.max(ans, (right - left - 1) * heights[index]);
                }
                peekValue = stack.isEmpty() ? Integer.MIN_VALUE : heights[stack.peek().getLast()];
            }

            if(heights[i] > peekValue){
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }else{
                stack.peek().addLast(i);
            }
        }

        while (!stack.isEmpty()){
            LinkedList<Integer> curList = stack.pop();
            int right = heights.length;
            int left = stack.isEmpty() ? -1 : stack.peek().getLast();
            for(int index : curList){
                //以heights[i]为高度能构成的矩形的宽就是right - left - 1
                ans = Math.max(ans, (right - left - 1) * heights[index]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        ArrayList只有get方法，LinkedList还有getLast和getFirst方法
//        ArrayList<Integer> list1 = new ArrayList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();
//        list1.get();
//        list2.getLast();

        int[] heights = {2,1,5,6,2,3};
        largestRectangleArea(heights);
    }
}
