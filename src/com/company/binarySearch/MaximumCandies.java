package com.company.binarySearch;

//leetcode 2226 每个小孩最多能分到多少糖果 字节面试题
public class MaximumCandies {
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for(int cur : candies){
            sum += cur;
        }
        long R = sum / k;
        long L = 0;
        long mid;
        while(L < R){
            //彻底终结二分死循环！
            //如果mid写成((R - L) >> 1) + L，则会发生死循环，原因在于L = mid，而mid又是向下取整，可能会导致L不收敛死循环
            //解决：（1）mid = ((R - L) >> 1) + L, L = mid + 1, R = mid，这样L会收敛，而R因为mid会向下取整也收敛，不会死循环
            //     （2）mid = ((R - L + 1) >> 1) + L, L = mid, R = mid - 1，这样mid向上取整则L收敛，R也会收敛
            mid = ((R - L + 1) >> 1) + L;
            if(can(candies, k, mid)){
                L = mid;
            }else {
                R = mid - 1;
            }
        }
        return (int)L;
    }

    private static boolean can(int[] candies, long k, long target) {
        long num = 0;
        for(int cur : candies){
            num += cur / target;
            if(num >= k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        maximumCandies(candies, 3);
    }
}
