package com.company.Bishi.meituan.practice;

import java.util.Scanner;

public class Juan3_P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String address = sc.nextLine();
        String[] splits = address.split("\\.");
        if(splits.length != 4 || address.startsWith(".") || address.endsWith(".")){
            System.out.print("invalid");
            return;
        }

        int[] nums = new int[4];
        for(int i = 0; i < 4; i++){
            if(splits[i].startsWith("0") && splits[i].length() > 1){
                System.out.print("invalid");
                return;
            }

            try{
                int cur = Integer.parseInt(splits[i]);
                if(cur > 255 || cur < 0){
                    System.out.print("invalid");
                    return;
                }
                nums[i] = cur;
            }catch (Exception e){
                System.out.print("invalid");
                return;
            }
        }

        if(nums[0] >= 128 && nums[0] < 192){
            System.out.print("B_address");
            return;
        }

        if(nums[0] >= 192 && nums[0] < 224){
            System.out.print("C_address");
            return;
        }

        if((nums[0] >= 1 && nums[0] < 126) || (nums[0] == 126 && nums[1] == 0 && nums[2] == 0 && nums[3] == 0)){
            System.out.print("A_address");
            return;
        }
        System.out.print("other");
    }
}
