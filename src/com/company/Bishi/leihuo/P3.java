package com.company.Bishi.leihuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] splits = str.split(" ");
        String orderBy = splits[0];
        String orderType = splits[1];
        Data ace = new Data("ace", 8, 4);
        Data bre = new Data("bre", 2, 3);
        Data cat = new Data("cat", 5, 2);
        Data dog = new Data("dog", 1, 1);
        ArrayList<Data> datas = new ArrayList<>();
        datas.add(ace);
        datas.add(bre);
        datas.add(cat);
        datas.add(dog);

        if(orderBy.equals("sort1") && orderType.equals("asc")){
            Collections.sort(datas, (o1, o2) -> o1.sort1 - o2.sort1);
        }else if(orderBy.equals("sort1") && orderType.equals("desc")){
            Collections.sort(datas, (o1, o2) -> o2.sort1 - o1.sort1);
        }else if(orderBy.equals("sort2") && orderType.equals("asc")){
            Collections.sort(datas, (o1, o2) -> o1.sort2 - o2.sort2);
        }else {
            Collections.sort(datas, (o1, o2) -> o2.sort2 - o1.sort2);
        }
        for(Data cur : datas){
            System.out.println(cur.name);
        }
    }

    static class Data{
        public String name;
        public int sort1;
        public int sort2;

        public Data(String name, int sort1, int sort2) {
            this.name = name;
            this.sort1 = sort1;
            this.sort2 = sort2;
        }
    }
}
