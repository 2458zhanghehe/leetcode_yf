package com.company.Bishi.Huawei.Day0828;

import java.util.HashMap;
import java.util.Scanner;

//元素消除  限制100ms 可能会超时
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int interval = sc.nextInt();

        // num : count
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(num, max);
        }

        int ans = 0;
        int count = 0;
        for(Integer cur : map.keySet()){
            int curCount = 0;
            int zeng = cur;
            while(zeng <= max){
                if(map.containsKey(zeng)){
                    curCount += map.get(zeng);
                    zeng += interval;
                }
            }
            if(curCount == count){
                ans = Math.min(ans, cur);
            }
            if(curCount > count){
                count = curCount;
                ans = cur;
            }
        }
        System.out.println(ans);
    }
}
