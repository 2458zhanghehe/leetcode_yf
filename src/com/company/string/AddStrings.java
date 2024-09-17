package com.company.string;

// leetcode 415 字符串相加
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int jin = 0;
        while(i >= 0 && j >= 0){
            int n1 = num1.charAt(i) - '0';
            int n2 =  num2.charAt(j) - '0';
            int tmp = n1 + n2 + jin;
            jin = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        while(i >= 0){
            int n1 = num1.charAt(i) - '0';
            int tmp = n1 + jin;
            jin = tmp / 10;
            res.append(tmp % 10);
            i--;
        }
        while(j >= 0){
            int n2 = num2.charAt(j) - '0';
            int tmp = n2 + jin;
            jin = tmp / 10;
            res.append(tmp % 10);
            j--;
        }
    
        if(jin == 1) res.append(1);
        return res.reverse().toString();
    }
}
