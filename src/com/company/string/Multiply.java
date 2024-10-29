package com.company.string;

// leetcode 43 字符串相乘 shopee没写出来
public class Multiply {
    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String[] subAns = new String[num2.length()];
        String zeros = "";

        for (int i = subAns.length - 1; i >= 0; i--) {
            String curSubAns = mulOnly1(num1, num2.charAt(i) - '0');
            subAns[i] = zeros + curSubAns;
            zeros = zeros + "0";
        }

        int jin = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder();

        while(true){
            boolean shouldBreak = true;
            int cur = jin;
            for (int i = 0; i < subAns.length; i++) {
                if(index < subAns[i].length()){
                    cur += subAns[i].charAt(index) - '0';
                    shouldBreak = false;
                }
            }
            if(shouldBreak){
                break;
            }
            jin = cur / 10;
            sb.append(cur % 10);
            index++;
        }
        if(jin > 0){
            sb.append(jin);
        }
        return sb.reverse().toString();
    }

    private static String mulOnly1(String num1, int num) {
        if(num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int jin = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int cur = (num1.charAt(i) - '0') * num;
            cur += jin;
            sb.append(cur % 10);
            jin = cur / 10;
        }
        if(jin > 0){
            sb.append(jin);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ans = multiply("9133", "0");
        System.out.println(ans);
    }
}
