package com.company.Bishi.ant.Day0929;

import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(--q >= 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] nums = new int[n + m + 1][2];
            for (int i = 0; i < n + m + 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                nums[i][0] = a;
                nums[i][1] = b;
            }

            //处理
            int x = 0;
            int y = 0;
            int sum = 0;
            int[][] xArray = new int[n + m + 1][3];
            int[][] yArray = new int[n + m + 1][3];
            for (int i = 0; i < n + m + 1; i++) {
                if(nums[i][0] >= nums[i][1]){
                    sum += nums[i][0];
                    x++;
                    xArray[i][0] = i;
                    xArray[i][1] = nums[i][0];
                    xArray[i][2] = nums[i][1];

                }else {
                    sum += nums[i][1];
                    y++;
                    yArray[i][0] = i;
                    yArray[i][1] = nums[i][0];
                    yArray[i][2] = nums[i][1];
                }
            }
            Arrays.sort(xArray, (o1,o2)->{
                return (o1[1] - o1[2]) - (o2[1] - o2[2]);
            });
            Arrays.sort(yArray, (o1,o2)->{
                return (o1[2] - o1[1]) - (o2[2] - o2[1]);
            });

            //计算结果
            int[] ans = new int[n + m + 1];
            for (int i = 0; i < n + m + 1; i++) {
                int cX = x;
                int cY = y;
                int cSum = sum;
                if(nums[i][0] >= nums[i][1]){
                    cSum -= nums[i][0];
                    cX--;
                }else {
                    cSum -= nums[i][1];
                    cY--;
                }
                int index = 0;
                while(cX < n){
                    if(yArray[index][0] == i){
                        index++;
                    }
                    cX++;
                    cY--;
                    cSum -= yArray[index][2];
                    cSum += yArray[index][1];
                    index++;
                }
                index = 0;
                while(cY < m){
                    if(xArray[index][0] == i){
                        index++;
                    }
                    cX--;
                    cY++;
                    cSum -= xArray[index][1];
                    cSum += xArray[index][2];
                    index++;
                }
                ans[i] = cSum;
            }

            //输出
            for (int i = 0; i < n + m + 1; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }
}
