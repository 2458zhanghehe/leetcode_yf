package com.company.Bishi.Huawei.Day0417;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class P2_2 {
    //son father
    private static HashMap<String, String> fatherMap = new HashMap<>();
    private static HashMap<String, int[]> countMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        String[][] strs = new String[n][4];
        for(int i = 0; i < n; i++) {
            String cur = sc.nextLine();
            String[] splits = cur.split(" ");
            strs[i][0] = splits[0];
            strs[i][1] = splits[1];
            strs[i][2] = splits[2];
            strs[i][3] = splits[3];
        }

        for(int i = 0; i < n; i++){
            union(strs[i]);
        }

        int ans = 0;
        Set<String> strings = fatherMap.keySet();
        for(String cur : strings){
            if(fatherMap.get(cur) == cur){
                int[] count = countMap.get(cur);
                int di = 5 * count[0] + 2 * count[1];
                if(di > m){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void union(String[] str) {
        int cls = Integer.parseInt(str[2]);
        int num = Integer.parseInt(str[3]);
        String name = str[0];
        String father = str[1];

        if(father.equals("*")){
            if(fatherMap.containsKey(name)){
                int[] count = countMap.get(name);
                count[cls] += num;
            }else {
                fatherMap.put(name,name);
                if(countMap.containsKey(name)){
                    int[] count = countMap.get(name);
                    count[cls] += num;
                }else {
                    int[] count = new int[2];
                    count[cls] = num;
                    countMap.put(name, count);
                }
            }
        }else {
            String ff = find(father);
            fatherMap.put(name, ff);
            int[] count = countMap.getOrDefault(ff, new int[2]);
            count[cls] += num;
            processName(name, count);
            countMap.put(ff, count);
        }
    }

    private static void processName(String name, int[] count) {
        if (countMap.containsKey(name)) {
            int[] count_name = countMap.get(name);
            count[0] += count_name[0];
            count[1] += count_name[1];
            countMap.remove(name);
        }
    }

    private static String find(String father) {
        if(fatherMap.containsKey(father) && !father.equals(fatherMap.get(father))){
            fatherMap.put(father, find(fatherMap.get(father)));
        }
        return fatherMap.getOrDefault(father, father);
    }
}
