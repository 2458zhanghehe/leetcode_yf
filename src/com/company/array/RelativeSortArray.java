package com.company.array;

import java.util.*;

// lcr 075 数组的相对排序
public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //arr1中 num出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int cur : arr2){
            set.add(cur);
        }
        for(int cur : arr1){
            if(set.contains(cur)){
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }else {
                list.add(cur);
            }
        }

        int index = 0;
        for(int cur : arr2){
            Integer count = map.get(cur);
            while(--count >= 0){
                arr1[index++] = cur;
            }
        }

        if(arr1.length > arr2.length){
            int offset = index;
            Collections.sort(list);
            while(index < arr1.length){
                arr1[index] =  list.get(index - offset);
                index++;
            }
        }
        return arr1;
    }

    public static int[] relativeSortArray1(int[] arr1, int[] arr2){
        int max = 0;
        for(int cur : arr1){
            max = Math.max(max, cur);
        }
        int[] counts = new int[max + 1];
        for (int cur : arr1){
            counts[cur]++;
        }

        int index = 0;
        for(int cur : arr2){
            while(--counts[cur] >= 0){
                arr1[index++] = cur;
            }
        }

        for (int i = 0; i < max + 1; i++) {
            while(counts[i] > 0){
                arr1[index++] = i;
                counts[i]--;
            }
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        System.out.println(Arrays.toString(relativeSortArray1(arr1, arr2)));
    }
}
