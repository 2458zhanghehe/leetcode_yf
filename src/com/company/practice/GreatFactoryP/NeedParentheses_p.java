package com.company.practice.GreatFactoryP;

public class NeedParentheses_p {
    public static int needParentheses(String s) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && count == 0) {
                sum++;
            } else {
                if (s.charAt(i) == '(') {
                    count++;
                } else {
                    count--;
                }
            }
        }
        sum += count;
        return sum;
    }


    public static boolean checkValid(String s) {
        int countXing = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && count == 0) {
                if (countXing != 0) {
                    countXing--;
                    continue;
                } else {
                    return false;
                }
            }
            if (s.charAt(i) == '*') {
                countXing++;
            } else if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        if (count > countXing) {
            return false;
        }
        count = 0;
        countXing = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(' && count == 0) {
                if (countXing != 0) {
                    countXing--;
                    continue;
                } else {
                    return false;
                }
            }
            if (s.charAt(i) == '*') {
                countXing++;
            } else if (s.charAt(i) == ')') {
                count++;
            } else {
                count--;
            }
        }
        if (count > countXing) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(((((*(((((*((**(((*)*((((**))*)*)))))))))((*(((((*(*(**)";
        System.out.println(checkValid(s));
    }

}
