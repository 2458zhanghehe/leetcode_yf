package com.company.GreatFactoryProblem;

//leetcode 6
public class ZTransaction {
    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int len = s.length();
        char[] sChar = new char[len];
        int j = 0;
        for(int i = 1; i <= numRows; i++){
            int index = i - 1;
            while(index < len){
                sChar[j++] = s.charAt(index);
                index += (i == numRows) ? (2 * numRows - 3 + 1) : (2 * numRows - 2 * i - 1 + 1);
                if(index >= len){
                    break;
                }
                sChar[j++] = s.charAt(index);
                index += (i == 1) ? (2 * numRows - 3 + 1) : (2 * i - 3 + 1);
            }
        }
        return String.valueOf(sChar);
    }

    public static void main(String[] args) {
        String s = "A";
        String convert = convert(s, 1);
    }
}
