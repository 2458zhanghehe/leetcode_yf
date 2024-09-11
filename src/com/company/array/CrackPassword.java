package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

// LCR 164 破解闯关密码
public class CrackPassword {
    public static String crackPassword1(int[] password) {
        ArrayList<String> list = new ArrayList<>();
        for(int word : password){
            list.add(String.valueOf(word));
        }

        StringBuilder sb = new StringBuilder();
        int minIndex;
        while(!list.isEmpty()){
            minIndex = 0;
            for(int i = 1; i < list.size(); i++){
                String min = list.get(minIndex);
                String cur = list.get(i);
                if(cur.charAt(0) < min.charAt(0)){
                    minIndex = i;
                }else if(cur.charAt(0) == min.charAt(0)){
                    long a = Long.valueOf(min + cur);
                    long b = Long.valueOf(cur + min);
                    if(a > b){
                        minIndex = i;
                    }
                }
            }
            sb.append(list.get(minIndex));
            list.remove(minIndex);
        }
        return sb.toString();
    }

    //直接自定义排序
    public static String crackPassword2(int[] password){
        String[] strs = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            strs[i] = String.valueOf(password[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long a = Long.valueOf(o1 + o2);
                long b = Long.valueOf(o2 + o1);
                return a <= b ? -1 : 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String cur : strs){
            sb.append(cur);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] password = {0,3,30,34,5,9};
        System.out.println(crackPassword1(password));
        System.out.println(crackPassword2(password));
    }
}
