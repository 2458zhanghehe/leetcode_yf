package com.company.recursionHuisu;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        process(list,"",n,n);
        return list;
    }

    private static void process(ArrayList<String> list, String path, int nZuo, int nYou) {
        if(nZuo == 0 && nYou == 0){
            list.add(path);
            return;
        }

        StringBuilder sb = new StringBuilder(path);
        if(nZuo == 0){
            while(--nYou >= 0){
                sb.append(')');
            }
            list.add(sb.toString());
            return;
        }

        if(nYou <= nZuo){
            process(list, path + '(',nZuo - 1,nYou);
        }else {
            process(list, path + '(',nZuo - 1,nYou);
            process(list, path + ')',nZuo,nYou - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list.toString());
    }
}
