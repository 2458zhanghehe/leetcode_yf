package com.company.practice2.sort2;

public class PartitionAndQuickSort {

    public static int[] SmallEqualBig(int[] arr, int L, int R){
        int small = L - 1;
        int big = R;

        int index = L;
        while(index < big){
            if(arr[index] < arr[R]){
                swap(arr, index++, ++small);
            }else if(arr[index] > arr[R]){
                swap(arr,index,--big);
            }else {
                index++;
            }
        }
        swap(arr,index,R);
        return new int[]{small,big + 1};
    }

    public static void swap(int[] arr,int i ,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort3(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length - 1);
    }

    public static void process(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int rand = (int)(Math.random()*(R - L + 1)) + L;
        swap(arr,rand,R);
        int[] smallEqualBig = SmallEqualBig(arr, L, R);
        process(arr,L,smallEqualBig[0]);
        process(arr,smallEqualBig[1],R);
    }

}
