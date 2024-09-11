package com.company.stack;

import java.util.Stack;

//leetcode 739 每日温度
//单调栈 保持从栈底到栈顶的有序
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                Integer cur = stack.pop();
                ans[cur] = i - cur;
            }
            stack.push(i);
        }
        return ans;
    }

}
