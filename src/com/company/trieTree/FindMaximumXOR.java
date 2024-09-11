package com.company.trieTree;

// leetcode 421 数组中两个数的最大异或值
public class FindMaximumXOR {

    //超时
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }


    TrieNode root = new TrieNode();
    public int findMaximumXOR1(int[] nums){
        int ans = 0;
        for(int num : nums){
            insert(num);
            ans = Math.max(ans, search(num));
        }
        return ans;
    }

    private int search(int num) {
        int ans = 0;
        TrieNode cur = root;
        for (int i = 30; i >= 0; i--) {
            int index = (num >> i) & 1;
            if(cur.nexts[index ^ 1] != null){
                ans += 1 << i;
                cur = cur.nexts[index ^ 1];
            }else {
                cur = cur.nexts[index];
            }
        }
        return ans;
    }

    public void insert(int num){
        TrieNode cur = root;
        for (int i = 30; i >= 0; i--) {
            int index = (num >> i) & 1;
            if(cur.nexts[index] == null){
                cur.nexts[index] = new TrieNode();
            }
            cur = cur.nexts[index];
        }
    }


    public class TrieNode{
        public TrieNode[] nexts;

        public TrieNode() {
            nexts = new TrieNode[2];
        }
    }
}
