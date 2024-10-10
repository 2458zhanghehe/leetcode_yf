package com.company.Bishi.Huawei.Day0927;

import java.util.*;

// 绩效互评人员分配
public class P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] splits = str.split(" ");
            int[] neighbours = new int[splits.length];
            for (int j = 0; j < splits.length; j++) {
                neighbours[j] = Integer.parseInt(splits[j]);
            }
            map.put(i, neighbours);
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        int l = 0;
        int r = 1;
        int level = 1;
        list1.add(0);
        set.add(0);
        boolean[] alreadyColored = new boolean[n];
        while(l < r){
            for (int i = l; i < r; i++) {
                Integer cur = list.get(i);
                set.add(cur);
                int[] neighbours = map.get(cur);
                for(int neighbour : neighbours){
                    if(set.contains(neighbour)){
                        continue;
                    }
                    if(alreadyColored[neighbour]){
                        System.out.println(-1);
                        return;
                    }
                    alreadyColored[neighbour] = true;
                    if((level & 1) == 1){
                        list2.add(neighbour);
                    }else {
                        list1.add(neighbour);
                    }

                    list.add(neighbour);
                }
            }
            l = r;
            r = list.size();
            level++;
        }
        System.out.println(list1);
        System.out.println(list2);
    }
}
