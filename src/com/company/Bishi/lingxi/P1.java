package com.company.Bishi.lingxi;

import java.util.Arrays;

public class P1 {
    public static String getMaxSharedPrefixString(String[] teamNameList){
        Arrays.sort(teamNameList);
        int nums = teamNameList.length;
        int nameLen = 1;
        while(true){
            if(nameLen > teamNameList[0].length()){
                break;
            }
            if(teamNameList[0].substring(0, nameLen).equals(teamNameList[nums - 1].substring(0, nameLen))){
                nameLen++;
            }else {
                break;
            }
        }
        return teamNameList[0].substring(0, nameLen - 1);
    }


    public static void main(String[] args) {
        String[] names = {"abc", "abc", "abc"};
        String comName = getMaxSharedPrefixString(names);
        System.out.println(comName);
    }
}
