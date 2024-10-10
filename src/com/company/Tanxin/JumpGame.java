package com.company.Tanxin;

//leetcode 45 跳跃游戏Ⅱ
public class JumpGame {
    public static int jumpGame(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int step = 0;
        int cur = 0;  //当前步最远能到达位置
        int next = arr[0];  //下一步最远能到达位置
        for (int i = 0; i < arr.length; i++) {
            if (i > cur) {
                step++;
                cur = next;
                next = i + arr[i];
            }
            next = Math.max(next, i + arr[i]);
        }
        return step;
    }

    public static int jumpGame2(int[] arr) {
        int step = 0;
        int i = 0;
        while (i < arr.length) {
            int max = 0;
            int maxIndex = 0;
            for (int j = i; j < i + arr[i]; j++) {
                if (j + arr[j] > max) {
                    max = j + arr[j];
                    maxIndex = j;
                }
            }
            step++;
            i = maxIndex;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 1, 6, 1, 2, 1};
        int i = jumpGame(a);
        System.out.println(i);
    }
}
