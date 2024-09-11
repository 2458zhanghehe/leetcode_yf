package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// LCR109 打开转盘锁
public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if(deadSet.contains("0000")){
            return -1;
        }
        if(target.equals("0000")){
            return 0;
        }
        HashSet<String> startSet = new HashSet<>();
        startSet.add("0000");
        HashSet<String> endSet = new HashSet<>();
        endSet.add(target);
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        int len = 0;
        while(!startSet.isEmpty() && !endSet.isEmpty()){
            //双向BFS，随机交替进行从start到end和从end到start
            if(startSet.size() > endSet.size()){
                HashSet<String> tmp = startSet;
                startSet = endSet;
                endSet = tmp;
            }
            HashSet<String> nextStartSet = new HashSet<>();
            for(String start : startSet){
                List<String> neighbours = getNeighbours(start);
                for(String neighbour : neighbours){
                    if(deadSet.contains(neighbour)){
                        continue;
                    }
                    if(endSet.contains(neighbour)){
                        return len + 1;
                    }
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        nextStartSet.add(neighbour);
                    }
                }
            }
            startSet = nextStartSet;
            len++;
        }
        return -1;
    }

    private static List<String> getNeighbours(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            char oldChar = strChar[i];
            strChar[i] = (oldChar == '9') ? '0' : (char) (oldChar + 1);
            res.add(String.valueOf(strChar));
            strChar[i] = (oldChar == '0') ? '9' : (char) (oldChar - 1);
            res.add(String.valueOf(strChar));
            strChar[i] = oldChar;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "1110";
        List<String> neighbours = getNeighbours(s);
        System.out.println(neighbours);
    }
}
