package com.company.array;

// LCR 191 按规则计算统计结果
public class StatisticalResult {
    public static int[] statisticalResult(int[] arrayA) {
        int sum = 1;
        int count0 = 0;
        for(int num : arrayA){
            sum *= num;
            if(num == 0){
                count0++;
            }
        }

        int[] arrayB = new int[arrayA.length];
        if(count0 > 1){
            return arrayB;
        }

        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] == 0){
                int tmp = 1;
                for (int j = 0; j < arrayA.length; j++) {
                    if(j == i){
                        continue;
                    }
                    tmp *= arrayA[j];
                }
                arrayB[i] = tmp;
            }else {
                arrayB[i] = sum / arrayA[i];
            }
        }
        return arrayB;
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 0, 4, 5};
        statisticalResult(arrayA);
    }
}
