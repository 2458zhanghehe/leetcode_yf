package com.company.practice.Tanxin;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//时间复杂度O(N^N)
public class Nqueue {

    public static List<List<String>> Nqueue1(int n) {
        List<List<String>> list = new LinkedList<>();
        if (n < 1) {
            return list;
        }
        int[] record = new int[n];
        process1(record, 0, n, list);
        return list;
    }

    public static void process1(int[] record, int i, int n, List<List<String>> list) {
        if (i == n) {
            List<String> list_tmp = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                char[] tmp = new char[n];
                Arrays.fill(tmp, '.');
                tmp[record[j]] = 'Q';
                list_tmp.add(new String(tmp));
            }
            list.add(list_tmp);
        }

        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                process1(record, i + 1, n, list);
            }
        }
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public static int Nqueue2(int n) {
        if (n < 1 || n > 32) {
            return -1;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;

        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit, int collim, int leftlim, int rightlim) {
        if (limit == collim) {
            return 1;
        }
        int pos = limit & (~(collim | leftlim | rightlim));
        int mostRightOne = 0;
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, collim | mostRightOne,
                    (leftlim | mostRightOne) << 1,
                    (rightlim | mostRightOne) >>> 1
            );
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(Nqueue2(n));
        System.out.println(Nqueue1(n));

    }
}
