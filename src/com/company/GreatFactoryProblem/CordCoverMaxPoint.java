package com.company.GreatFactoryProblem;

import javax.management.MBeanRegistration;
import java.util.Arrays;

public class CordCoverMaxPoint {
    /* 给定一个有序数组arr，代表坐落在x轴上的点
    给定一个正数K，代表绳子的长度
    返回绳子最多能压中几个点？ 注意：即使绳子边缘处盖住点也算
    */

    //第一种，使用循环+二分查找，每次二分查找时间复杂度为O(logN)，总时间复杂度为O(N*logN)
    public static int CCMP1(int[] nums, int len) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = findleft(nums, nums[i] - len);
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static int findleft(int[] arr, int target) {
        int L = 0;
        int R = arr.length - 1;
        int mid = 0;
        int left = -1;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (arr[mid] >= target) {
                left = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return left;
    }

    //使用滑动窗口法，时间复杂度为O(N)
    public static int CCMP2(int[] arr, int len) {
        int ans = 0;
        for (int l = 0, r = 0; r < arr.length; r++) {
            while (arr[r] - arr[l] > len) {
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static int CCMP3(int[] nums, int len) {
        int ans = 0;
        for (int L = 0, R = 0; L < nums.length; L++) {
            while ((R < nums.length) && (nums[R] - nums[L] <= len)) {
                ans = Math.max(ans, R - L + 1);
                R++;
            }
        }
        return ans;
    }

    public static int[] generatearray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue));
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        int times = 1000;
        int maxsize = 100;
        int maxvalue = 1000;
        for (int i = 0; i < times; i++) {
            int[] arr = generatearray(maxsize, maxvalue);
            int len = (int) (Math.random() * maxvalue);

            if (CCMP1(arr, len) != CCMP2(arr, len)) {

                System.out.println("error");
                break;
            }
        }
    }


}
