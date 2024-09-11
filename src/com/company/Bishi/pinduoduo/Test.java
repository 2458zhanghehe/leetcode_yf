package com.company.Bishi.pinduoduo;

public class Test {
    public static void main(String[] args) {
//        int a = 'a';
//        System.out.println(a);
//
//        String str = "abcds";
//        System.out.println(str.substring(0,2));
//        System.out.println(str.substring(2,5));

//        String str = "dsf";
//        getDouble(str.toCharArray());

        String str = "abcds";
        StringBuilder sb = new StringBuilder();
        sb.append(str,0,2);
        //sb.append(str,2,5);
        System.out.println(sb.toString());

    }

    private static char[] getDouble(char[] str) {
        char[] res = new char[2 * str.length + 1];
        for(int i = 0; i < res.length; i++){
            res[i] = (i & 1) != 0 ? str[(i - 1) / 2] : '#';
        }
        System.out.println(String.valueOf(res));
        return res;
    }
}
