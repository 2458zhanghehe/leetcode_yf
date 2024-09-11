package com.company.Bishi.tencent;


import java.util.HashSet;
import java.util.Scanner;


//leetcode128 做过，但面试时完全没印象
public class P3 {
    public static int longest(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int curLen = 1;
            while(set.contains(++cur)){
                curLen++;
            }
            ans = Math.max(ans,curLen);
        }
        return ans;
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //重要！ HashSet也是哈希表，增删改查操作时间复杂度也为O(1)
        HashSet<Integer> set = new HashSet<>();
        for(int cur : nums){
            set.add(cur);
        }
        int ans = 0;
        for(Integer cur : set){
            if(!set.contains(cur - 1)){
                int len = 1;
                while(set.contains(++cur)){
                    len++;
                }
                ans = Math.max(ans,len);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(" ");
        int[] nums = new int[splits.length];
        for(int i = 0; i < splits.length; i++){
            nums[i] = Integer.parseInt(splits[i]);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int ans = 0;
        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            if(set1.contains(cur)){
                continue;
            }
            int curLen = 1;
            while(set.contains(++cur)){
                set1.add(cur);
                curLen++;
            }
            ans = Math.max(ans,curLen);
        }
        System.out.println(ans);
    }
}
