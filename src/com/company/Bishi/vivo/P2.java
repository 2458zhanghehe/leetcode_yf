package com.company.Bishi.vivo;

import java.util.ArrayDeque;
import java.util.Arrays;

public class P2 {
    public int[] findFluctuations (int[] memoryUsage, int k) {
        int[] max = new int[memoryUsage.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if(deque.isEmpty()){
                deque.addLast(memoryUsage[i]);
                continue;
            }
            while(!deque.isEmpty() && deque.peekLast() < memoryUsage[i]){
                deque.pollLast();
            }
            deque.addLast(memoryUsage[i]);
        }
        int l = 0;
        for(int r = k; r < memoryUsage.length; r++){
            max[l] = deque.peekFirst();
            while(!deque.isEmpty() && deque.peekLast() < memoryUsage[r]){
                deque.pollLast();
            }
            deque.addLast(memoryUsage[r]);
            if(deque.peekFirst() == memoryUsage[l]){
                deque.pollFirst();
            }
            l++;
        }
        max[l] = deque.peekFirst();


        int[] min = new int[memoryUsage.length - k + 1];
        deque.clear();
        for (int i = 0; i < k; i++) {
            if(deque.isEmpty()){
                deque.addLast(memoryUsage[i]);
                continue;
            }
            while(!deque.isEmpty() && deque.peekLast() > memoryUsage[i]){
                deque.pollLast();
            }
            deque.addLast(memoryUsage[i]);
        }
        l = 0;
        for(int r = k; r < memoryUsage.length; r++){
            min[l] = deque.peekFirst();
            while(!deque.isEmpty() && deque.peekLast() > memoryUsage[r]){
                deque.pollLast();
            }
            deque.addLast(memoryUsage[r]);
            if(deque.peekFirst() == memoryUsage[l]){
                deque.pollFirst();
            }
            l++;
        }
        min[l] = deque.peekFirst();

        int[] ans = new int[max.length];
        for (int i = 0; i < max.length; i++) {
            ans[i] = max[i] - min[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        P2 p2 = new P2();
        int[] memory = {80, 100, 70, 90, 60, 85, 75, 95, 110};
        System.out.println(Arrays.toString(p2.findFluctuations(memory, 4)));
    }
}
