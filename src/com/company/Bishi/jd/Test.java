package com.company.Bishi.jd;

public class Test {
    private static int test(int[] arr, int b){
        int cur = arr[0];
        int need = arr.length;
        for (int i = 1; i < arr.length; i++) {
            if(cur + b > arr[i]){
                need--;
            }else {
                cur = arr[i];
            }
        }
        return need;
    }

    public static void main(String[] args) {

    }
}
