package com.company.Tanxin;

import java.util.ArrayList;
import java.util.List;


//leetcode 68
public class FullJustify {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        int preIndex = 0;
        ArrayList<String> list = new ArrayList<>();
        while(index < words.length){
            int res = maxWidth;
            while(res - words[index].length() - 1 >= 0){
                res -= (words[index].length() + 1);
                index++;
                if(index == words.length){
                    break;
                }
            }
            if(index < words.length && res == words[index].length()){
                index++;
                res = 0;
            }else {
                res++;
            }

            if(index - preIndex - 1 == 0 || index == words.length){
                int add = res;
                StringBuilder sb = new StringBuilder();
                int i = preIndex;
                for(; i < index - 1; i++){
                    sb.append(words[i] + " ");

                }
                sb.append(words[i]);
                for(int j = 0; j < add; j++){
                    sb.append(" ");
                }
                list.add(sb.toString());
                preIndex = index;
                continue;
            }

            int add = res/(index - preIndex - 1);
            int mod = res % (index - preIndex - 1);

            StringBuilder sb = new StringBuilder();
            int i = preIndex;
            for(; i < index - 1; i++){
                sb.append(words[i] + " ");
                for(int j = 0; j < add; j++){
                    sb.append(" ");
                }
                if(i - preIndex < mod){
                    sb.append(" ");
                }
            }
            preIndex = index;
            sb.append(words[i]);
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        List<String> list = fullJustify(words, 20);
        for(String tmp : list){
            System.out.println(tmp);
        }
    }
}
