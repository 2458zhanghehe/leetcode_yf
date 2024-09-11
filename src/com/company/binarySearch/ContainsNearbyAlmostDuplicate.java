package com.company.binarySearch;

import java.util.ArrayList;

//leetcode 220 存在重复元素Ⅲ
public class ContainsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(indexDiff == 0){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int size = indexDiff + 1;

        for (int l = 0, r = 0; r < nums.length; r++) {
            if(list.size() < size){
                int index = binaryFindIndex(list, nums[r]);
                if (isContain(nums[r], index, list, valueDiff)) return true;
                list.add(index, nums[r]);
            }else {
                int preIndex = binaryFindIndex(list, nums[l++]);
                list.remove(preIndex);
                int index = binaryFindIndex(list, nums[r]);
                if (isContain(nums[r], index, list, valueDiff)) return true;
                list.add(index, nums[r]);
            }
        }
        return false;
    }

    private static boolean isContain(long cur, int index, ArrayList<Integer> list, int valueDiff) {
        if(index - 1 >= 0 && cur - (long) list.get(index - 1) <= valueDiff){
            return true;
        }
        if(index < list.size() && Math.abs((long) list.get(index) - cur) <= valueDiff){
            return true;
        }
        if(index + 1 < list.size() && (long) list.get(index) - cur <= valueDiff){
            return true;
        }
        return false;
    }


    private static int binaryFindIndex(ArrayList<Integer> list, int num) {
        if(list.isEmpty()){
            return 0;
        }

        int l = 0;
        int r = list.size() - 1;
        if(l == r){
            return list.get(0) > num ? 0 : 1;
        }

        while(l < r){
            int mid = ((r - l) >> 1) + l;
            Integer midVal = list.get(mid);
            if(midVal >= num){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(l == list.size() - 1 && list.get(l) < num){
            l++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int indexDiff = 0;
        int valDiff = 1;
        containsNearbyAlmostDuplicate(nums, indexDiff, valDiff);
    }
}
