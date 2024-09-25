package com.company.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode 2092 找出知晓所有密码的专家
public class FindAllPeople {
    private static int[] father = new int[100000];

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        build(n,firstPerson);
        Arrays.sort(meetings, (o1, o2) -> o1[2] - o2[2]);
        int NumsMeeting = meetings.length;
        for (int i = 0; i < NumsMeeting;) {
            int pre = meetings[i][2];
            int j = i;
            do {
                union(meetings[j][0], meetings[j][1]);
                j++;
            }while(j < NumsMeeting && meetings[j][2] == pre);

            //撤销无效集合
            for(int k = i; k < j; k++){
                int a = meetings[k][0];
                int b = meetings[k][1];
                if(find(a) != 0){
                    father[a] = a;
                }
                if(find(b) != 0){
                    father[b] = b;
                }
            }
            i = j;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(find(i) == 0){
                list.add(i);
            }
        }
        return list;
    }

    private static void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if(x != y){
            if(x == 0){
                father[y] = 0;
            }else if(y == 0){
                father[x] = 0;
            }else {
                father[x] = y;
            }
        }
    }

    private static int find(int i) {
        if(i != father[i]){
            father[i] = find(father[i]);
        }
        return father[i];
    }

    private static void build(int n, int firstPerson) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        father[firstPerson] = 0;
    }

    public static void main(String[] args) {
        int[][] meeting = {{0,1,1}};
        findAllPeople(10000, meeting,1);
    }
}





//public class FindAllPeople {
//    private static int[] father = new int[100000];
//    private static boolean[] know = new boolean[100000];
//
//    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        build(n,firstPerson);
//        Arrays.sort(meetings, (o1, o2) -> o1[2] - o2[2]);
//        int NumsMeeting = meetings.length;
//        for (int i = 0; i < NumsMeeting;) {
//            int pre = meetings[i][2];
//            int j = i;
//            do {
//                union(meetings[j][0], meetings[j][1]);
//                j++;
//            }while(j < NumsMeeting && meetings[j][2] == pre);
//
//            //撤销无效集合
//            for(int k = i; k < j; k++){
//                int a = meetings[k][0];
//                int b = meetings[k][1];
//                if(!know[find(a)]){
//                    father[a] = a;
//                }
//                if(!know[find(b)]){
//                    father[b] = b;
//                }
//            }
//            i = j;
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if(know[find(i)]){
//                list.add(i);
//            }
//        }
//        return list;
//    }
//
//    private static void union(int i, int j) {
//        int x = find(i);
//        int y = find(j);
//        if(x != y){
//            father[x] = y;
//            know[y] |= know[x];
//        }
//    }
//
//    private static int find(int i) {
//        if(i != father[i]){
//            father[i] = find(father[i]);
//        }
//        return father[i];
//    }
//
//    private static void build(int n, int firstPerson) {
//        for (int i = 0; i < n; i++) {
//            father[i] = i;
//        }
//        know[0] = true;
//        father[firstPerson] = 0;
//    }
//
//    public static void main(String[] args) {
//        int[][] meeting = {{0,1,1}};
//        findAllPeople(10000, meeting,1);
//    }
//}
