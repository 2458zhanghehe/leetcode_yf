package com.company.Bishi.Huawei.Day0410;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {

        HashMap<Integer,HashSet<Integer>> indexMap = new HashMap<>();
        HashMap<HashSet<Integer>,Integer> Sizemap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                m[i][j] = sc.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            indexMap.put(i,set);
            Sizemap.put(set,0);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(m[i][j] != 0){
                    HashSet<Integer> seti = indexMap.get(i);
                    if(!seti.contains(j)){
                        HashSet<Integer> setj = indexMap.get(j);
                        Integer sizei = Sizemap.get(seti);
                        Integer sizej = Sizemap.get(setj);
                        //因为for里面对Seti进行了修改，所以put时hascode不一样，同地址不同hascode的set会保存两个
                        Sizemap.remove(seti);
                        for(Integer tmp : setj){
                            seti.add(tmp);
                            indexMap.put(tmp,seti);
                        }
                        Sizemap.put(seti, sizei + sizej + m[i][j]);
                        //重要重要重要  这里你不要对setj进行元素删除，否则hascode变化，虽然地址没变，key找不到
                        //一般很少对Key进行修改
                        //仅仅当Set为key时
                        Sizemap.remove(setj);
                    }
                }
            }
        }

        Collection<Integer> values = Sizemap.values();
        for(Integer cur : values){
            if(cur != 0){
                System.out.print(cur +  " ");
            }
        }
    }
}
