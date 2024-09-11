package com.company.trieTree;

import java.util.Arrays;

/*牛牛和他的朋友们约定了一套接头密钥系统，用于确定彼此的身份
密钥右一组数字表示，两个密钥被认为是一致的，如果满足以下条件：
密钥b的长度不超过密钥a的长度
对于任意0 <= i < length(b) - 1,有 b[i + 1] - b[i] == a[i + 1] - a[i];
现在给定了m个密钥b的数组，以及n个密钥a的数组
请返回一个长度为m的数组ans，表示每个密钥b右多少个一致的密钥a
1 <= m, n <= 1000
* */
public class CountConsistentKeys {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4, 5}, {2, 4, 6, 8}, {1, 4, 7, 10}};
        int[][] b = {{3, 4, 5, 6, 7, 8}, {2, 4, 6, 8}, {1, 3, 5, 7, 9}};
        int[] ans = countConsistentKeys(a, b);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] countConsistentKeys(int[][] a, int[][] b){
        TrieTree trieTree = new TrieTree();
        StringBuilder sb = new StringBuilder();
        for(int[] nums : a){
            //清空sb
            sb.setLength(0);
            for(int i = 0; i < nums.length - 1; i++){
                sb.append((nums[i + 1] - nums[i]) + "#");
            }
            trieTree.insert(sb.toString());
        }

        int[] ans = new int[b.length];
        int j = 0;
        for(int[] nums : b){
            sb.setLength(0);
            for(int i = 0; i < nums.length - 1; i++){
                sb.append((nums[i + 1] - nums[i]) + "#");
            }
            ans[j++] = trieTree.find(sb.toString());
        }
        return ans;
    }





    static class TrieNode{
        int pass;
        int end;
        TrieNode[] nexts;
        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[12];
        }
    }

    static class TrieTree{

        private TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(String str){
            char[] chars = str.toCharArray();
            TrieNode curNode = root;
            curNode.pass++;
            for(char curChar : chars){
                int index;
                if(curChar == '-'){
                    index = 10;
                }else if(curChar == '#'){
                    index = 11;
                }else {
                    index = curChar - '0';
                }
                if(curNode.nexts[index] == null){
                    curNode.nexts[index] = new TrieNode();
                }
                curNode.nexts[index].pass++;
                curNode = curNode.nexts[index];
            }
            curNode.end++;
        }

        public int find(String str){
            char[] chars = str.toCharArray();
            TrieNode curNode = root;
            for(char curChar : chars){
                int index;
                if(curChar == '-'){
                    index = 10;
                }else if(curChar == '#'){
                    index = 11;
                }else {
                    index = curChar - '0';
                }
                if(curNode.nexts[index] == null){
                    return 0;
                }
                curNode = curNode.nexts[index];
            }
            return curNode.pass;
        }
    }
}
