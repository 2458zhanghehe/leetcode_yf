package com.company.array;


//leetcode 42 接雨水
public class TrappingRainWater {
    public static int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int p1 = 1;
        int p2 = height.length - 2;
        int LMax = height[0];
        int RMax = height[height.length - 1];
        int water = 0;

        while(p1 <= p2){
            if(LMax < RMax){
                water += Math.max(LMax - height[p1], 0);
                LMax = Math.max(LMax, height[p1]);
                p1++;
            }else{
                water += Math.max(RMax - height[p2], 0);
                RMax = Math.max(RMax, height[p2]);
                p2--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int water = trap(arr);
        System.out.println(water);
    }
}
