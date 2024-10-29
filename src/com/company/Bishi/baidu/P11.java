package com.company.Bishi.baidu;

import java.util.Arrays;

public class P11 {
    public int getAns(int[] nums, int target){
        int ans = 0;
        Arrays.sort(nums);
        boolean alreadyS = false;
        String targetS = String.valueOf(target);
        for (int i = 0; i < targetS.length(); i++) {
            if(alreadyS){
                ans = ans * 10 + nums[nums.length - 1];
                continue;
            }
            int curTarget = targetS.charAt(i) - '0';
            int cur = findLastLE(nums, curTarget);
            if(cur < curTarget){
                alreadyS = true;
            }
            ans = ans * 10 + cur;
        }
        return ans;
    }

//    private int getMosRight(int[] nums, int curTarget) {
//        int l = 0;
//        int r = nums.length - 1;
//        int mid;
//        while(l < r){
//            mid = ((r - l) >> 1) + l;
//            if(nums[mid] > curTarget){
//                r = mid - 1;
//            }else {
//                l = mid;
//            }
//        }
//        return nums[l];
//    }

    public static int findLastLE(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1; // 初始化为-1，表示如果没有找到符合条件的元素

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] <= target) {
                result = mid; // 更新结果，并尝试找到更大的满足条件的索引
                left = mid + 1; // 向右移动，寻找是否有更大的值
            } else {
                right = mid - 1; // 向左移动
            }
        }

        return nums[result];
    }

    public static void main(String[] args) {
        P11 p11 = new P11();
        int[] nums = {1, 2, 4, 9};
        int ans = p11.getAns(nums, 2533);
        System.out.println(ans);
    }

}
