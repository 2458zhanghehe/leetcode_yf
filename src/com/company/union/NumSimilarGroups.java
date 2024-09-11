package com.company.union;

//LC 839 相似字符串组
public class NumSimilarGroups {
    //虽然目标是字符串，但是由于它在字符串数组中下标没动，所以可以用下标标识唯一字符串，也就可以使用father数组
    private int[] father = new int[300];
    private int setNums = 0;

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        build(n);
        //判断 i 和 i + 1 ... n是否相似，不用回头查
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                boolean similar = isSimilar(strs[i], strs[j]);
                if(similar){
                    union(i, j);
                }
            }
        }
        return setNums;
    }

    private void union(int i, int j) {
        int x = findFather(i);
        int y = findFather(j);
        if(x != y){
            father[x] = y;
            setNums--;
        }

    }

    private int findFather(int i) {
        if(i != father[i]){
            father[i] = findFather(father[i]);
        }
        return father[i];
    }

    private boolean isSimilar(String str1, String str2) {
        int diff = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diff++;
                if(diff > 2){
                    return false;
                }
            }
        }
        return true;
    }

    private void build(int length) {
        for(int i = 0; i < length; i++){
            father[i] = i;
        }
        setNums = length;
    }
}
