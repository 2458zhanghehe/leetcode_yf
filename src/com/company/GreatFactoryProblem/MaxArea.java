package com.company.GreatFactoryProblem;

public class MaxArea {
    public static int maxArea(int[] height) {
        if(height.length == 2){
            return Math.min(height[0],height[1]);
        }
        int L = 0;
        int R = height.length - 1;
        int ans = 0;
        while(L < R){
            if(height[L] < height[R]){
                ans = Math.max(ans, (R - L) * height[L]);
                L++;
            }else {
                ans = Math.max(ans, (R - L) * height[R]);
                R--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int area = maxArea(height);
        System.out.println(area);
    }
}
