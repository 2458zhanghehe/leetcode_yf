package com.company;

import com.company.Bishi.tenxunMusic.P2;

import java.util.*;
import java.util.concurrent.Executors;

import static com.company.sort.Code02_BubbleSort.swap;

public class Test {

    private int[] lastLocation = new int[256];
    private int maxLenNoRepeatSubString(String str){
        char[] chars = str.toCharArray();
        int ans = 1;
        Arrays.fill(lastLocation, -1);
        for(int l = 0, r = 0; r < chars.length; r++){
            l = Math.max(l, lastLocation[chars[r]] + 1);
            lastLocation[chars[r]] = r;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void heapify(int[] arr, int heapSize, int index){
        int leftChildIndex = 2 * index + 1;
        while(leftChildIndex < heapSize){
            int maxIndex = (leftChildIndex + 1) < heapSize && arr[leftChildIndex + 1] > arr[leftChildIndex] ? leftChildIndex + 1 : leftChildIndex;
            maxIndex = arr[index] < arr[maxIndex] ? maxIndex : index;
            if(maxIndex == index){
                break;
            }
            swap(arr, index, maxIndex);
            index = maxIndex;
            leftChildIndex = 2 * index + 1;
        }
    }

    private String str = "das";
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> objects = new PriorityQueue<>((o1, o2)-> o2 - o1);
        StringBuilder sb = new StringBuilder();
        sb.append(123);
        sb.append(2);
        System.out.println(sb.toString());

    }
}
