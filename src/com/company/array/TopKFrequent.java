package com.company.array;

import java.util.*;

// leetcode 347 前K个高频元素
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k){
            return nums;
        }
        Arrays.sort(nums);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int pre = nums[0];
        for (int i = 0; i < nums.length; ) {
            int cnt = 0;
            while(i < nums.length && nums[i] == pre){
                i++;
                cnt++;
            }
            if(priorityQueue.size() < k){
                priorityQueue.add(new int[]{pre, cnt});
            }else if(priorityQueue.peek()[1] < cnt){
                priorityQueue.poll();
                priorityQueue.add(new int[]{pre, cnt});
            }
            pre = i < nums.length ? nums[i] : pre;
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }

    public static int[] topKFrequent2(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Integer key : map.keySet()) {
            int cnt = map.get(key);
            if(priorityQueue.size() < k){
                priorityQueue.add(new int[]{key, cnt});
            }else if(priorityQueue.peek()[1] < cnt){
                priorityQueue.poll();
                priorityQueue.add(new int[]{key, cnt});
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int[] ans = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ans));
    }
}
