package com.company.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> MapKeyK;
        private HashMap<Integer, K> MapKeyIndex;
        private int nums;

        public Pool() {
            MapKeyK = new HashMap<K, Integer>();
            MapKeyIndex = new HashMap<Integer, K>();
            nums = 0;
        }

        public void insert(K k) {
            if (MapKeyK.containsKey(k)) {
                return;
            }
            MapKeyK.put(k, nums);
            MapKeyIndex.put(nums++, k);
        }

        public void delete(K k) {
            if (!MapKeyK.containsKey(k)) {
                return;
            }
            int tmp = MapKeyK.get(k);
            MapKeyK.remove(k);
            MapKeyK.put(MapKeyIndex.get(nums - 1), tmp);
            MapKeyIndex.put(tmp, MapKeyIndex.get(nums - 1));
            nums--;
        }

        public K getRand() {
            if (nums == 0) {
                return null;
            }
            return MapKeyIndex.get((int) (Math.random() * nums));
        }

    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "zhang");
        map.put(1, "li");
        System.out.println(map.get(1));
    }

}
