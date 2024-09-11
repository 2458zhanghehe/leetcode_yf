package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode 15 三数之和
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //只要 和顺序无关的数组，上来直接排序
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while(left < right){
                if(nums[left] + nums[right] == target){
                    ArrayList<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    ans.add(cur);
                    while(nums[++left] == nums[left - 1]){
                        if(left >= nums.length - 1){
                            break;
                        }
                    }
                    while(nums[--right] == nums[right + 1]){
                        if(right <= 0){
                            break;
                        }
                    }
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }
}
