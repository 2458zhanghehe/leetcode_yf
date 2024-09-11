package com.company.GreatFactoryProblem;

//leetcode 58
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {

        int len = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(' ' != s.charAt(i)){
                len++;
            }else if(len != 0){
                return len;
            }
        }
        return len;
    }

    public static void main(String[] args) {

        String s = "fly me to    the moon  ";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }
}
