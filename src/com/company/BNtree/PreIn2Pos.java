package com.company.BNtree;

import java.util.Arrays;
import java.util.HashMap;

//根据二叉树的先序遍历和中序遍历生成后序遍历
//和PreIn2Tree思想相同
public class PreIn2Pos {

    public static int[] preIn2Pos(int[] pre, int[] in){
        int[] pos = new int[pre.length];
        //val index
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < in.length; i++){
            inMap.put(in[i],i);
        }
        process1(pre, in, pos,0,pre.length - 1,0,in.length - 1,0,pos.length - 1, inMap);
        return pos;
    }

    private static void process1(int[] pre, int[] in, int[] pos,
                                int prei, int prej, int ini, int inj, int posi, int posj, HashMap<Integer, Integer> inMap) {
        if(prei > prej){
            return;
        }
        if(prei == prej){
            pos[posi] = pre[prei];
            return;
        }

        pos[posj] = pre[prei];
        int find = inMap.get(pre[prei]);
        process1(pre,in,pos,prei + 1, prei + find - ini, ini, find - 1, posi, posi + find - ini - 1, inMap);
        process1(pre,in,pos,prei + find - ini + 1, prej, find + 1, inj, posi + find - ini, posj - 1, inMap);
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] in = {4,5,2,6,7,3,1};
        int[] pos = preIn2Pos(pre, in);
        System.out.println(Arrays.toString(pos));
    }
}
