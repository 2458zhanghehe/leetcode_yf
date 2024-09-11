package com.company.Bishi.shouQianBa;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[] doors = new char[m];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = sc.nextLine().charAt(0);
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        for(char door : doors){
            if(door == 'A'){
                int tmp = nums[0];
                for (int i = 1; i < n; i++) {
                    nums[i - 1] = nums[i];
                }
                nums[n - 1] = tmp;
            }else if(door == 'B'){
                nums = reverse(nums);
            }
        }

        for(int num : nums){
            System.out.println(num);
        }
    }

    private static int[] reverse(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums.length - 1 - i];
        }
        return res;
    }
}
