package com.company.Tanxin;


import java.util.*;

public class BestArrange {
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
