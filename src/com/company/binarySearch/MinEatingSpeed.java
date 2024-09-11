package com.company.binarySearch;

//LCR 073 爱吃香蕉的狒狒
public class MinEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h) {
        int min = piles[0];
        int max = piles[0];

        for(int pile : piles){
            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }

        if(h == piles.length){
            return max;
        }

        int avg = h / piles.length;
        int left = min / avg + (min % avg == 0 ? 0 : 1);
        int right = max / avg + (max % avg == 0 ? 0 : 1);
        while(left < right){
            int mid = ((right - left) >> 1) + left;
            int cur = 0;
            for (int j = 0; j < piles.length; j++) {
                cur += piles[j] / mid + (piles[j] % mid == 0 ? 0 : 1);
                if(cur > h){
                    break;
                }
            }
            if(cur > h){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
