package com.company.GreatFactoryProblem;

import java.util.HashMap;
import java.util.HashSet;

//leetcode 219
public class ContainsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //val index
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                Integer index = hashMap.get(nums[i]);
                if(i - index <= k){
                    return true;
                }
            }
            hashMap.put(nums[i],i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        int L = 0;
        int R = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        while(R < nums.length){
            if(hashSet.contains(nums[R])){
                return true;
            }
            if(R - L < k){
                hashSet.add(nums[R++]);
            }else if(hashSet.isEmpty()){
                break;
            } else {
                hashSet.remove(nums[L++]);
                hashSet.add(nums[R++]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,1};
        boolean b = containsNearbyDuplicate2(a, 0);
        System.out.println(b);
    }
}
