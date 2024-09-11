package com.company.GreatFactoryProblem;

//leetcode12
public class IntToRoman {
    public static String intToRoman(int num) {

        String ans = "";
        int cntM = num / 1000;
        for(int i = 1; i <= cntM; i++){
            ans += "M";
        }
        num -= cntM*1000;

        if(num >= 900){
            ans += "CM";
            num -= 900;
        }else if(num >= 500){
            ans += "D";
            num -= 500;
        }else if(num >= 400){
            ans += "CD";
            num -= 400;
        }
        int cntC = num / 100;
        for(int i = 1; i <= cntC; i++){
            ans += "C";
        }
        num -= cntC*100;

        if(num >= 90){
            ans += "XC";
            num -= 90;
        }else if(num >= 50){
            ans += "L";
            num -= 50;
        }else if(num >= 40){
            ans += "XL";
            num -= 40;
        }
        int cntX = num / 10;
        for(int i = 1; i <= cntX; i++){
            ans += "X";
        }
        num -= cntX * 10;

        if(num == 9){
            ans += "IX";
            num -= 9;
        }else if(num >= 5){
            ans += "V";
            num -= 5;
        }else if(num == 4){
            ans += "IV";
            num -= 4;
        }
        for(int i = 1; i <= num; i++){
            ans += "I";
        }
        return ans;
    }

    public static String intToRoman2(int num){
        int[] val = new int[]{1000, 900, 500, 400,
                100, 90, 50, 40, 10, 9, 5, 4, 1};

        String[] str = new String[]{"M", "CM", "D", "CD", "C",
                "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < val.length; i++){
            int curVal = val[i];
            String curStr = str[i];

            while(num >= curVal){
                sb.append(curStr);
                num -= curVal;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);

//        StringBuilder builder = new StringBuilder();
//        builder.append("abcd");
//        builder.append("efg");
//        System.out.println(builder.toString());
    }
}
