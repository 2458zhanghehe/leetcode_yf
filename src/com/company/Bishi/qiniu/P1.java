package com.company.Bishi.qiniu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P1 {
    public ArrayList<ArrayList<Integer>> setZeroes (ArrayList<ArrayList<Integer>> matrix) {
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> curRow = matrix.get(i);
            for (int j = 0; j < curRow.size(); j++) {
                if(curRow.get(j) == 0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(Integer row : rowSet){
            ArrayList<Integer> curRow = matrix.get(row);
            Collections.fill(curRow, 0);
        }

        for(Integer col : colSet){
            for (int i = 0; i < matrix.size(); i++) {
                ArrayList<Integer> curRow = matrix.get(i);
                curRow.set(col, 0);
            }
        }
        return matrix;
    }
}
