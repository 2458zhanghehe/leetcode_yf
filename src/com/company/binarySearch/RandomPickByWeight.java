package com.company.binarySearch;

//LCR 071 按权重随机选择
public class RandomPickByWeight {
    private int[] preSum;
//    public Solution(int[] w) {
    public RandomPickByWeight(int[] w){
        preSum = new int[w.length + 1];
        for(int i = 1; i <= w.length; i++){
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        //随机生成范围在0到15的整数
        int i = (int) (Math.random() * preSum[preSum.length - 1] + 1);
        int left = 0;
        int right = preSum.length - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(preSum[mid] < i){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left - 1;
    }
}
