package com.company.linklist;

import java.util.ArrayList;
import java.util.List;

//LCR 058 我的日程安排表Ⅰ
class MyCalendar {
    private List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book1(int start, int end) {
        if(list.isEmpty()){
            int[] calender = new int[]{start, end};
            list.add(calender);
            return true;
        }
        //这里可以用二分查找，找到大于等于end的最左边界，然后判断能不能插入
        int index = 0;
        while(index < list.size() && end > list.get(index)[1]){
            index++;
        }
        if(index - 1 >= 0 && list.get(index - 1)[1] > start){
            return false;
        }
        if(index < list.size() && list.get(index)[0] < end){
            return false;
        }
        list.add(index, new int[]{start, end});
        return true;
    }


    public boolean book2(int start, int end) {
        if(list.isEmpty()){
            int[] calender = new int[]{start, end};
            list.add(calender);
            return true;
        }
        if(list.size() == 1){
            int[] pre = list.get(0);
            if(end <= pre[0]){
                list.add(0, new int[]{start, end});
                return true;
            }
            if(start >= pre[1]){
                list.add(1, new int[]{start, end});
                return true;
            }
            return false;
        }

        int l = 0;
        int r = list.size() - 1;
        while(l < r){
            int mid = ((r - l) >> 1) + l;
            int curEnd = list.get(mid)[1];
            if(curEnd >= end){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(list.get(l)[1] < end){
            l++;
        }

        if(l - 1 >= 0 && list.get(l - 1)[1] > start){
            return false;
        }
        if(l < list.size() && list.get(l)[0] < end){
            return false;
        }
        list.add(l, new int[]{start, end});
        return true;
    }
}