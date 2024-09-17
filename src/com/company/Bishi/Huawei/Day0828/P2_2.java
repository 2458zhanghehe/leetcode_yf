package com.company.Bishi.Huawei.Day0828;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 元素消除
// 直接统计余数，因为一个递增的序列， a a+interval, a+2*interval ... a+n*interval对interval
// 取余结果一定为a。
public class P2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int interval = sc.nextInt();

        // 余数 : count
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            int yu = num % interval;
            map.put(yu, map.getOrDefault(yu,0) + 1);
        }

        int ans = 0;
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == count){
                ans = Math.min(ans, entry.getKey());
            }
            if(entry.getValue() > count){
                ans = entry.getKey();
                count = entry.getValue();
            }
        }
        System.out.println(ans);
    }
}
