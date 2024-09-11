package com.company.Bishi.yintai;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            char max = '1';
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) > max){
                    max = s.charAt(i);
                }
            }
            int Jin = Integer.parseInt(String.valueOf(max),16);
            for(int i = Jin + 1; i <= 16; i++){
                int ans = Integer.parseInt(s, i);
                System.out.println(ans);
            }
        }
    }
}