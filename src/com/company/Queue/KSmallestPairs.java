package com.company.Queue;

import com.company.linklist.RemoveNthFromEnd;

import java.util.*;

//leetcode 373 查找和最小的K对数字
public class KSmallestPairs {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]);
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        //int[]为引用类型，不能直接放进set！！！
        int[] cur = new int[]{0,0};
        priorityQueue.add(cur);
        set.add("0_0");
        while(--k >= 0 && !priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            int[] next1 = new int[]{poll[0] + 1, poll[1]};
            int[] next2 = new int[]{poll[0], poll[1] + 1};
            if(!set.contains(next1[0] + "_" + next1[1]) && next1[0] < nums1.length && next1[1] < nums2.length){
                priorityQueue.add(next1);
                set.add(next1[0] + "_" + next1[1]);
            }
            if(!set.contains(next2[0] + "_" + next2[1]) && next2[0] < nums1.length && next2[1] < nums2.length){
                priorityQueue.add(next2);
                set.add(next2[0] + "_" + next2[1]);
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,4,5,6};
        int[] num2 = {3,5,7,9};
        List<List<Integer>> ans = kSmallestPairs(num1, num2, 20);
        System.out.println(ans.toString());
    }
}
