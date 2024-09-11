package com.company.array;

//leetcode 4 寻找两个正序数组的中位数
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m  = nums1.length;
        int n = nums2.length;
        int aimIndex = m + ((n - m) >> 1);
        int longer;
        int[] longerNums;
        int shorter;
        int[] shorterNums;
        if(m > n){
            longer = m;
            longerNums = nums1;
            shorter = n;
            shorterNums = nums2;
        }else {
            shorter = m;
            shorterNums = nums1;
            longer = n;
            longerNums = nums2;
        }
        //题目限定两个数组长度不会同时为0
        if(shorter == 0){
            if((longer & 1) == 1){
                return longerNums[longer / 2];
            }else {
                return (longerNums[longer / 2] + longerNums[longer / 2 - 1]) / 2.0;
            }
        }
        //是否是奇数
        boolean isOdd = ((m + n) & 1) == 1;

        if(shorterNums[shorter - 1] <= longerNums[0]){
            int pl = aimIndex - shorter;
            if(isOdd){
                return longerNums[pl];
            }else {
                if(pl > 0){
                    return (longerNums[pl] + longerNums[pl - 1]) / 2.0;
                }else {
                    return (shorterNums[shorter - 1] + longerNums[pl]) / 2.0;
                }
            }
        }

        if(shorterNums[0] >= longerNums[longer - 1]){
            if(isOdd){
                return longerNums[aimIndex];
            }else{
                if(aimIndex == longer){
                    return (longerNums[longer - 1] + shorterNums[0]) / 2.0;
                }else {
                    return (longerNums[aimIndex - 1] + longerNums[aimIndex]) / 2.0;
                }
            }
        }

        int pl = aimIndex - shorter;
        int ps = shorter - 1;


        while(shorterNums[ps] > longerNums[pl]){
            if(pl + 1 < longer && shorterNums[ps] < longerNums[pl + 1]){
                if(isOdd){
                    return shorterNums[ps];
                }else {
                    return (shorterNums[ps] + (ps - 1 >= 0 ? Math.max(shorterNums[ps - 1], longerNums[pl]) : longerNums[pl]))/ 2.0;
                }
            }else if(ps > 0){
                ps--;
                pl++;
            }else {
                pl++;
                if(isOdd){
                    return longerNums[pl];
                }else {
                    return (longerNums[pl] + longerNums[pl - 1]) / 2.0;
                }
            }
        }
        if(isOdd){
            return longerNums[pl];
        }else {
            return (longerNums[pl] + (pl - 1 >= 0 ? Math.max(shorterNums[ps], longerNums[pl - 1]) : shorterNums[ps])) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4};
        int[] nums2 = {1, 2, 3};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
