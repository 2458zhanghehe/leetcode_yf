package com.company.Bishi.Huawei.Day0904;

import java.util.*;

//好友推荐系统
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int l = sc.nextInt();

        //index : friends
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        while(--m >= 0){
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            List<Integer> list1 = map.getOrDefault(f1, new ArrayList<>());
            list1.add(f2);
            map.put(f1, list1);
            List<Integer> list2 = map.getOrDefault(f2, new ArrayList<>());
            list2.add(f1);
            map.put(f2, list2);
        }
        List<Integer> friendsOfK = map.get(k);


        ArrayList<int[]> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(friendsOfK.contains(i + 1) || i + 1 == k){
                continue;
            }
            int count = CountSameFriends(map.get(i + 1), friendsOfK);
            ansList.add(new int[]{i + 1, count});
        }

        Collections.sort(ansList, (o1, o2) -> {
            if(o1[1] != o2[1]){
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < l; i++) {
            if(i >= ansList.size()){
                System.out.print("0 ");
            }else {
                System.out.print(ansList.get(i)[0] + " ");
            }
        }
    }

    private static int CountSameFriends(List<Integer> list1, List<Integer> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        int m = 0;
        int n = 0;
        int ans = 0;
        while(m < list1.size() && n < list2.size()){
            if(list1.get(m) < list2.get(n)){
                m++;
            }else if(list1.get(m) > list2.get(n)){
                n++;
            }
            else {
                ans++;
                m++;
                n++;
            }
        }
        return ans;
    }
}
