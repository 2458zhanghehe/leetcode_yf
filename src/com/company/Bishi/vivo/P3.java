package com.company.Bishi.vivo;

import java.util.HashMap;

public class P3 {
    public boolean canEqualDistribution (int[] prices, int k) {
        if(k <= 1 || prices == null || prices.length == 0){
            return true;
        }
        if(prices.length < k){
            return false;
        }
        long sum = 0;
        for(int price : prices){
            sum += price;
        }
        if((sum % k) != 0){
            return false;
        }
        long target = sum / k;
        // price: count
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int price : prices){
            if(price > target){
                return false;
            }
            if(price == target){
                continue;
            }
            int delta = (int) (target - price);
            if(map.containsKey(delta)){
                Integer count = map.get(delta);
                if(count == 1){
                    map.remove(delta);
                }else {
                    map.put(delta, count - 1);
                }
            }else {
                map.put(price, map.getOrDefault(price, 0) + 1);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
        int[] prices = {5,4,1,3,2,3,2};
        System.out.println(p3.canEqualDistribution(prices, 4));
    }
}
