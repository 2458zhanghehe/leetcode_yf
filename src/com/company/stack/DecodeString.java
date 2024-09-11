package com.company.stack;

import java.util.LinkedList;
import java.util.Stack;

//leetcode 394 字符串解码
public class DecodeString {
    //递归法
    public static String decodeString(String s) {
        Info info = process(s,0);
        return info.str;
    }

    private static Info process(String s, int i) {
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            if(s.charAt(i) > '0' && s.charAt(i) <= '9'){
                int r = i + 1;
                while(s.charAt(r) >= '0' && s.charAt(r) <= '9'){
                    r++;
                }
                int k = Integer.parseInt(s.substring(i,r));
                Info info = process(s, r + 1);
                while(--k >= 0){
                    sb.append(info.str);
                }
                i = info.index;
            }else if(s.charAt(i) == ']'){
                return new Info(sb.toString(), i + 1);
            }else{
                sb.append(s.charAt(i++));
            }
        }

        return new Info(sb.toString(), i);
    }


    static class Info{
        public String str;
        public int index;

        public Info(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    //栈  //栈里存的是k和前一个res（preRes）  出栈时 curS = preRes + k * curRes
    public static String decodeString2(String s) {
        LinkedList<Integer> kStack = new LinkedList<>();
        LinkedList<String> stack = new LinkedList<>();

        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if(c == '['){
                kStack.addLast(k);
                stack.addLast(res.toString());
                k = 0;
                res.setLength(0);
            }else if(c == ']'){
                Integer curK = kStack.removeLast();
                String preRes = stack.removeLast();
                String curRes = res.toString();
                res.setLength(0);
                res.append(preRes);
                while(--curK >= 0){
                    res.append(curRes);
                }
            }else if(c >= '0' && c <= '9'){
                k = k * 10 + Integer.parseInt(c + "");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }




    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
}
