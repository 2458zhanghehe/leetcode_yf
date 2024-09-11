package com.company.practice.Tanxin;

import java.util.Arrays;
import java.util.Comparator;

//贪心笔试概率20%，面试考得比较少
//贪心问题多用堆和排序解决

public class BestArrangeMeeting {
    public static class Meeting {
        public int start;
        public int end;

        public Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static class Endtimecompare implements Comparator<Meeting> {
        @Override
        public int compare(Meeting m1, Meeting m2) {
            return m1.end - m2.end;
        }
    }

    public static int MostNumsOfMeeting(Meeting[] meet, int opentime) {
        if (meet == null) {
            return 0;
        }
        Arrays.sort(meet, new Endtimecompare());
        int nums = 0;
        for (int i = 0; i < meet.length; i++) {
            if (meet[i].start >= opentime) {
                nums++;
                opentime = meet[i].end;
            }
        }
        return nums;
    }

}
