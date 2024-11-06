package com.company.math;

//字节面试原题：找到一个数字n，n是6的最小倍数且n只有0和1
//只需要满足既是2的倍数也是3的倍数即可保证是6的倍数
//判断一个数是3的倍数：各位数字之和是3的倍数，这个数字就是3的倍数。（这个规律只适用于3和9）
//因为是偶数，所以各位必须为0，最高位为1，所以中间添两个1即为最小答案。1110
public class Beishu {
    public static int getMin6(){
        String s = "1";
        return process(s);
    }

    private static int process(String s) {
        if(s.length() > 8){
            return Integer.MAX_VALUE;
        }
        Integer num = Integer.parseInt(s);
        if((num * 10) % 6 == 0){
            return num * 10;
        }
        int ans1 = process(s + "0");
        int ans2 = process(s + "1");
        return Math.min(ans1, ans2);
    }

    public static int getMin6_2(){
        return 1110;
    }

    public static void main(String[] args) {
        System.out.println(getMin6());
    }

}
