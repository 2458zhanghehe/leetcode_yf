package com.company.recursionHuisu;

import java.util.*;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        process(digits,0,list,"");
        return list;
    }

    private static void process(String digits, int index, List<String> list, String curStr) {
        if(index == digits.length()){
            list.add(curStr);
            return;
        }

        char cur = digits.charAt(index);
        if(cur < '7'){
            char tmp = (char) (cur + (cur - '2') * 2 + 47);
            String curStr1 = curStr + tmp;
            process(digits, index + 1, list, curStr1);
            tmp += 1;
            String curStr2 = curStr + tmp;
            process(digits, index + 1, list, curStr2);
            tmp += 1;
            String curStr3 = curStr + tmp;
            process(digits, index + 1, list, curStr3);
        }else if(cur == '7'){
            String curStr1 = curStr + 'p';
            process(digits, index + 1, list, curStr1);
            String curStr2 = curStr + 'q';
            process(digits, index + 1, list, curStr2);
            String curStr3 = curStr + 'r';
            process(digits, index + 1, list, curStr3);
            String curStr4 = curStr + 's';
            process(digits, index + 1, list, curStr4);
        }else if(cur == '8'){
            String curStr1 = curStr + 't';
            process(digits, index + 1, list, curStr1);
            String curStr2 = curStr + 'u';
            process(digits, index + 1, list, curStr2);
            String curStr3 = curStr + 'v';
            process(digits, index + 1, list, curStr3);
        }else {
            String curStr1 = curStr + 'w';
            process(digits, index + 1, list, curStr1);
            String curStr2 = curStr + 'x';
            process(digits, index + 1, list, curStr2);
            String curStr3 = curStr + 'y';
            process(digits, index + 1, list, curStr3);
            String curStr4 = curStr + 'z';
            process(digits, index + 1, list, curStr4);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println(list.toString());
    }
}
