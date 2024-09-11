package com.company.Bishi.qiniu;

public class P3 {
    public static int maxWine (int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int ans = 0;
        if((len & 1) == 1){
            ans = process(nums, 0, len - 1);
            ans = Math.max(ans,process(nums, 1, len));
            ans = Math.max(ans,process(nums, 2, len));
        }else {
            ans = Math.max(process(nums, 0, len - 1), process(nums, 1, len));
        }
        return ans;
    }

    private static int process(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 4, 2};
        System.out.println(maxWine(nums));
    }
}
