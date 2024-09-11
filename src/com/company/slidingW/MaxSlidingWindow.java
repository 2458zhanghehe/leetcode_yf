package com.company.slidingW;

import java.util.ArrayDeque;

// leetcode 239 滑动窗口最大值 左64
public class MaxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if(deque.isEmpty()){
                deque.addLast(nums[i]);
                continue;
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int l = 0;
        for (int r = k; r < nums.length; r++) {
            ans[l] = deque.peekFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[r]){
                deque.pollLast();
            }
            deque.addLast(nums[r]);
            if(deque.peekFirst() == nums[l]){
                deque.pollFirst();
            }
            l++;
        }
        ans[l] = deque.peekFirst();
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        maxSlidingWindow(nums, 4);
    }
}
