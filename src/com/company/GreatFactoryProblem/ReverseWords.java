package com.company.GreatFactoryProblem;

//leetcode 151 反转字符串中的单词
public class ReverseWords {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split(" ");

//        int index = 0;
//        while("".equals(split[index])){
//            index++;
//        }

        StringBuilder sb = new StringBuilder();
        for(int i = split.length - 1; i >= 0; i--){
            sb.append(split[i]);
            if(i > 0 && !("".equals(split[i]))){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWords2(String s) {
        s = s.trim();   //删除字符串的前后空格
        int len = s.length();
        int i = len - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            while(i >=0 && s.charAt(i) != ' '){
                i--;
            }
            sb.append(s.substring(i + 1, j + 1) + " ");
            while(i >=0 && s.charAt(i) == ' '){
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = " hello world ";
        String reverseWords = reverseWords2(s);
        System.out.println(reverseWords);

        s = "absc";
        String substring = s.substring(0, 3 + 1);
        System.out.println(substring);
    }
}
