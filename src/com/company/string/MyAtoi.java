package com.company.string;

 // leetcode 8 字符串转换整数
public class MyAtoi {
    public static int myAtoi(String s) {
        int len = s.length();

        if(len == 0){
            return 0;
        }

        int i = 0;
        while(i < len && s.charAt(i) == ' '){
            i++;
        }

        boolean neg = false;
        if(i < len && s.charAt(i) == '-'){
            neg = true;
            i++;
        }else if(i < len && s.charAt(i) == '+'){
            i++;
        }

        while(i < len && s.charAt(i) == '0'){
            i++;
        }

        long ans = 0;
        while(i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            ans = ans * 10 + s.charAt(i) - '0';
            if(ans >= Integer.MAX_VALUE + 1L){
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }
        return neg ? -(int) ans : (int)ans;
    }

     public static void main(String[] args) {
        String str = "2147483648";
        myAtoi(str);
     }
}
