package com.company.Bishi.meituan.Day0309;

import com.company.Graph.Kruskal;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFound {

    //key:son value:father
    private HashMap<Integer, Integer> fatherMap;
    private HashMap<Integer, Integer> sizeMap;

    public UnionFound(List<Integer> list){
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();

        for(Integer tmp : list){
            fatherMap.put(tmp,tmp);
            sizeMap.put(tmp,1);
        }
    }

    private Integer findFather(Integer k){
        Stack<Integer> stack = new Stack<>();
        while (!fatherMap.get(k).equals(k)){
            stack.add(k);
            k = fatherMap.get(k);
        }

        while(!stack.isEmpty()){
            fatherMap.put(stack.pop(),k);
        }
        return k;
    }

    public boolean isSameSet(Integer x, Integer y){
        Integer xFather = findFather(x);
        Integer yFather = findFather(y);
        return xFather.equals(yFather);
    }

    public void union(Integer x, Integer y){
        Integer xFather = findFather(x);
        Integer yFather = findFather(y);
        if(xFather.equals(yFather)){
            return;
        }
        Integer xSize = sizeMap.get(xFather);
        Integer ySize = sizeMap.get(yFather);

        if(xSize > ySize){
            fatherMap.put(yFather,xFather);
            sizeMap.put(xFather,xSize + ySize);
            sizeMap.remove(yFather);
        }else {
            fatherMap.put(xFather,yFather);
            sizeMap.put(yFather,xSize + ySize);
            sizeMap.remove(xFather);
        }
    }
}
