package com.company.Dp;

import java.util.ArrayList;
import java.util.List;

//leetcode118 杨辉三角
public class YangHuiTrangle {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if(numRows <= 0){
            return res;
        }
        //第一行、第二行
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        res.add(row1);
        if(numRows == 1){
            return res;
        }
        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        res.add(row2);
        if(numRows == 2){
            return res;
        }

        for (int i = 3; i <= numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            List<Integer> preRow = res.get(i - 2);
            for (int j = 2; j < i; j++) {
                curRow.add(preRow.get(j - 2) + preRow.get(j - 1));
            }
            curRow.add(1);
            res.add(curRow);
        }
        return res;
    }
}
