package com.company.Bishi.pinduoduo;

import java.util.*;

public class P3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, List<Integer>> fromMap = new HashMap<>();
        HashMap<Integer, List<Integer>> toMap = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int[] cur = new int[]{from,to};
            queue.add(cur);
        }

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            process(fromMap,toMap,cur[0],cur[1],queue);
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(fromMap.containsKey(i) && toMap.containsKey(i)){
                List<Integer> list1 = fromMap.get(i);
                List<Integer> list2 = toMap.get(i);
                if(list1.size() + list2.size() + 1 >= n){
                    ans++;
                }
            }
        }
        System.out.print(ans);
    }

    private static void process(HashMap<Integer, List<Integer>> fromMap,
                         HashMap<Integer, List<Integer>> toMap, Integer from, Integer to, Queue<int[]> queue){
        if(toMap.containsKey(from)){
            List<Integer> list = toMap.get(from);
            list.add(to);
            toMap.put(from,list);
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(to);
            toMap.put(from,list);
        }

        if(fromMap.containsKey(to)){
            List<Integer> list = fromMap.get(to);
            list.add(from);
            fromMap.put(to,list);
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(from);
            fromMap.put(to,list);
        }

        if(toMap.containsKey(to)){
            List<Integer> list = toMap.get(to);
            for(Integer i : list){
                queue.add(new int[]{from,i});
            }
        }
        if(fromMap.containsKey(from)){
            List<Integer> list = fromMap.get(from);
            for(Integer i : list){
                queue.add(new int[]{i,to});
            }
        }
    }
}
