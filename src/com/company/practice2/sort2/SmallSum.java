package com.company.practice2.sort2;

public class SmallSum {

    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int sum = 0;
        int mergeSize = 1;
        int N = arr.length;

        while(mergeSize < N){
            int L = 0;
            while(L < N){
                int mid = L + mergeSize - 1;
                if(mid > N - 1){
                    break;
                }
                int R = Math.min(N - 1, mid + mergeSize);
                sum += merge(arr,L,R,mid);
                L = R + 1;
            }
            mergeSize <<= 1;
        }
        return sum;
    }

    public static int merge(int[] arr,int L,int R,int mid){
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int sum = 0;
        int i = 0;
        while(p1 <= mid && p2 <= R){
            if(arr[p1] < arr[p2]){
                sum += arr[p1]*(R - p2 + 1);
                help[i++] = arr[p1++];
            }else {
                help[i++] = arr[p2++];
            }
        }

        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];

        }
        for(i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] s = {2, 4, 5, 1, 7, 3};
        System.out.println(smallSum(s));
    }

}
