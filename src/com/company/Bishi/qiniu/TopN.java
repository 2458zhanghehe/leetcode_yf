package com.company.Bishi.qiniu;

import java.util.*;

//注意区分 TopN 和 TopKTimes 一个是前N大的数， 一个是出现次数为前N的数
public class TopN {

    //改为小根堆限制大小为n
    public static int[] topN(int[] nums, int n){
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int tmp : nums){
            queue.add(tmp);
        }
        int[] ans = new int[n];
        while(--n >= 0 && !queue.isEmpty()){
            ans[n] = queue.poll();
        }
        return ans;
    }

    //改为小根堆限制大小为n
    public static List<Integer> topN_Ans(int[] nums, int n){
        if(n <= 0 || nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int cur : nums){
            if(queue.size() < n){
                queue.add(cur);
            }else {
                if(queue.peek() < cur){
                    queue.poll();
                    queue.add(cur);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }

    // 单调栈是找左右最近的大于值  错误
    public static int[] topN1(int[] nums, int n){
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        for(int cur : nums){
            if(stack.isEmpty()){
                stack.add(cur);
            }else if(stack.peek() < cur){
                Integer pop = stack.pop();
                stack.add(cur);
                if(stack.size() < n){
                    stack.add(pop);
                }
            }
        }

        int[] ans = new int[n];
        while(--n >= 0 && !stack.isEmpty()){
            ans[n] = stack.pop();
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {1,5,2,4};
        int[] ans = topN(nums, 2);
        System.out.println(Arrays.toString(ans));
    }
}
