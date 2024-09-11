package com.company.Bishi.hema;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P2 {
    public static int[] getTop3(int[] nums){
        if(nums.length <= 3){
            return nums;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add(num);
            if(queue.size() > 3){
                queue.poll();
            }
        }
        int[] ans = new int[3];
        for (int i = 2; i >= 0; i--) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,3,7,9,11,8,65,24};
        System.out.println(Arrays.toString(getTop3(nums)));
    }
}
