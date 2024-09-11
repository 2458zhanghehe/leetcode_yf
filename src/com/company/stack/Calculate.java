package com.company.stack;

import java.util.Stack;

//leetcode224 基本计算器
public class Calculate {
    public static int calculate(String s) {
        return f(s, 0)[0];
    }

    private static int[] f(String s, int i) {
        Stack<Integer> stackNum = new Stack<>();
        Stack<Character> stackChar = new Stack<>();
        while(i < s.length()){
            if(s.charAt(i) == '+'){
                stackChar.add(s.charAt(i));
                i++;
            }else if(s.charAt(i) == '-'){
                while(s.charAt(i + 1) == ' '){
                    i++;
                }
                if(s.charAt(i + 1) == '('){
                    int[] cur = f(s, i + 2);
                    stackNum.add(-cur[0]);
                    stackChar.add('+');
                    i = cur[1];
                }else {
                    int pre = ++i;
                    while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                        i++;
                    }
                    int cur = 0;
                    int tmp = 1;
                    for(int k = i - 1; k >= pre; k--){
                        cur += (s.charAt(k) - '0') * tmp;
                        tmp *= 10;
                    }
                    stackNum.add(-cur);
                    stackChar.add('+');
                }
            }else if(s.charAt(i) == '('){
                int[] cur = f(s, i + 1);
                stackNum.add(cur[0]);
                i = cur[1];
            }else if(s.charAt(i) == ')'){
                break;
            }else if(s.charAt(i) == ' '){
                i++;
            }
            else {
                int pre = i;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    i++;
                }
                int cur = 0;
                int tmp = 1;
                for(int k = i - 1; k >= pre; k--){
                    cur += (s.charAt(k) - '0') * tmp;
                    tmp *= 10;
                }
                stackNum.add(cur);
            }
        }

        while(!stackChar.isEmpty()){
            Character curChar = stackChar.pop();
            Integer b = stackNum.pop();
            Integer a = stackNum.isEmpty() ? 0 : stackNum.pop();
            if(curChar == '-'){
                stackNum.add(a - b);
            }else {
                stackNum.add(a + b);
            }
        }
        return new int[]{stackNum.pop(),i + 1};
    }

    public static void main(String[] args) {
        String s = "1-11";
        int ans = calculate(s);
        System.out.println(ans);
    }
}
