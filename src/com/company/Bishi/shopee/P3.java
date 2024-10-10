package com.company.Bishi.shopee;

public class P3 {
    public int jump(int[] steps) {
        int step = 0;
        int cur = 0;
        int next = steps[0];
        for (int i = 0; i < steps.length; i++) {
            if(i > cur){
                step++;
                cur = next;
            }
            next = Math.max(next, steps[i] + i);
        }
        return step;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
        int[] steps = {3,0,2,1,1,4,3,0,0,4,3,3};
        int ans = p3.jump(steps);
        System.out.println(ans);
    }
}
