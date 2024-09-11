package com.company.stack;

import java.util.Arrays;
import java.util.Stack;

// LCR 037 行星碰撞
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        //注意asteroids不等于0
        Stack<Integer> stack = new Stack<>();
        for(int cur : asteroids){
            //栈为空、栈顶小于0，cur大于0时，直接无脑入栈
            if(stack.isEmpty() || cur > 0 || stack.peek() < 0){
                stack.add(cur);
                continue;
            }
            //隐藏条件: cur < 0  stack空和栈顶正负可能会因为pop而变化
            while(!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty() || stack.peek() < 0){
                stack.add(cur);
            }else if(stack.peek() == -cur){
                stack.pop();
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }
}
