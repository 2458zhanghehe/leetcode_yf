package com.company.Bishi.Huawei.Day0828;

import java.util.*;
import java.util.stream.Collectors;

//参加博览会
public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] days = new int[n][2];
        int minDay = Integer.MAX_VALUE;
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            days[i][0] = sc.nextInt();
            days[i][1] = sc.nextInt();
            minDay = Math.min(minDay, days[i][0]);
            maxDay = Math.max(maxDay, days[i][1]);
        }

        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = days[i][0]; j <= days[i][1]; j++) {
                List<int[]> list = map.getOrDefault(j, new ArrayList<>());
                list.add(new int[]{days[i][0], days[i][1], i});
                map.put(j, list);
            }
        }

        int ans = 0;
        boolean[] already = new boolean[n];
        for (int i = minDay; i <= maxDay; i++) {
            List<int[]> list = map.get(i);
            //当前开放的展览，过滤掉已参观的，再根据关闭日期优先排序，（后面不一样要）关闭日期相同的，再根据开放日期排序
            List<int[]> curDayOpen = list.stream().filter(o1 -> {
                        return !already[o1[2]];
                    })
                    .sorted((o1, o2) -> {
                        if (o1[1] != o2[1]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    }).collect(Collectors.toList());
            int tmp = 1;
            while(tmp <= k && tmp - 1 < curDayOpen.size()){
                ans++;
                already[curDayOpen.get(tmp - 1)[2]] = true;
                tmp++;
            }
        }
        System.out.println(ans);
    }
}
