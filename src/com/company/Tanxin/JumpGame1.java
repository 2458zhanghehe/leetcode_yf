package com.company.Tanxin;

public class JumpGame1 {
    public static boolean jumpGame(int[] arr) {

        int next = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (next >= arr.length - 1) {
                return true;
            }
            next = Math.max(i + arr[i], next);
            if (i == next) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 0, 4};
        System.out.println(jumpGame(arr));
    }
}
