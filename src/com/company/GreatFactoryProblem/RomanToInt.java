package com.company.GreatFactoryProblem;

import java.util.HashMap;

//leetcode 13
public class RomanToInt {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);

        int sum = 0;
        for(int i = 0; i < s.length(); i++){

            Integer cur = hashMap.get(s.charAt(i));
            if(i + 1 < s.length()){
                Integer next = hashMap.get(s.charAt(i + 1));
                if(cur < next){
                    sum += next - cur;
                    i++;
                    continue;
                }
            }
            sum += cur;
        }
        return sum;
    }

    private static int getValue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

}
