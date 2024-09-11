package com.company.GreatFactoryProblem;


//leetcode 695
public class Island {
    public static int[] island(int[][] m) {
        int height = m.length;
        int weight = m[0].length;
        int nums = 0;
        int maxarea = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (m[i][j] == 1) {
                    nums++;
                    maxarea = Math.max(infect(m, i, j), maxarea);
                }
            }
        }
        return new int[]{nums, maxarea};
    }

    public static int infect(int[][] m, int i, int j) {
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] != 1) {
            return 0;
        }
        int area = 0;
        m[i][j] = 2;
        area += infect(m, i - 1, j) + infect(m, i + 1, j) + infect(m, i, j - 1) + infect(m, i, j + 1) + 1;
        return area;
    }

    public static void main(String[] args) {
        int[][] m = {{0, 0, 1, 0, 1, 0}, {1, 1, 1, 0, 1, 0}, {1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}};

        System.out.println(island(m)[1]);
    }
}
