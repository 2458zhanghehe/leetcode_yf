package com.company.Bishi.qiniu;

import java.util.Arrays;

public class P3_2 {
    public static int maxWine (int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        return Math.max(process(Arrays.copyOfRange(nums, 0, len - 1)),
                process(Arrays.copyOfRange(nums,1, len)));
    }

    private static int process(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums){
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }
}
