package com.company.Bishi.leihuo;

import java.util.ArrayList;

public class P1 {
    public ArrayList<ArrayList<Long>> diff (ArrayList<Long> leftIds, ArrayList<String> leftValues,
                                            ArrayList<Long> rightIds, ArrayList<String> rightValues) {
        ArrayList<Long> changeList = new ArrayList<>();
        ArrayList<Long> addList = new ArrayList<>();
        ArrayList<Long> deleteList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < leftIds.size() && j < rightIds.size()){
            Long leftId = leftIds.get(i);
            Long rightId = rightIds.get(j);

            if(leftId < rightId){
                deleteList.add(leftId);
                i++;
            }else if(leftId > rightId){
                addList.add(rightId);
                j++;
            }else {
                if(!leftValues.get(i).equals(rightValues.get(j))){
                    changeList.add(leftId);
                }
                i++;
                j++;
            }
        }

        while(i < leftIds.size()){
            deleteList.add(leftIds.get(i));
            i++;
        }

        while(j < rightIds.size()){
            addList.add(rightIds.get(j));
            j++;
        }

        ArrayList<ArrayList<Long>> ansList = new ArrayList<>();
        ansList.add(addList);
        ansList.add(changeList);
        ansList.add(deleteList);
        return ansList;
    }
}
