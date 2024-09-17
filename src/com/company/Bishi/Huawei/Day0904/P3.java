package com.company.Bishi.Huawei.Day0904;

import java.util.Arrays;
import java.util.Scanner;

//维修工
public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int[][] kehu = new int[n][3];
        for (int i = 0; i < n; i++) {
            kehu[i][0] = scanner.nextInt();
            kehu[i][1] = scanner.nextInt();
            kehu[i][2] = scanner.nextInt();
        }
        Arrays.sort(kehu, (o1, o2) -> {return o1[2] - o2[2];});
        double ans = process(0, kehu, k, k, x, y, x, y);
        System.out.println(ans);
    }

    private static double process(int i, int[][] kehu, int rest, int k, int curX, int curY, int x, int y) {
        if(i == kehu.length){
            return getDistance(curX, curY, x, y);  //服务完成，回公司
        }
        // 回公司
        double ans1 = getDistance(curX, curY, x, y) + getDistance(x, y, kehu[i][0], kehu[i][1]) +
                process(i + 1, kehu, k - 1, k, kehu[i][0], kehu[i][1], x, y);

        //不回直接去到当前客户
        double ans2 = Double.MAX_VALUE;
        if(rest > 0){
            ans2 = getDistance(curX, curY, kehu[i][0], kehu[i][1]) + process(i + 1, kehu, rest - 1, k, kehu[i][0], kehu[i][1], x, y);
        }
        return Math.min(ans1, ans2);
    }

    private static double getDistance(int curX, int curY, int x, int y) {
        return Math.sqrt((curX - x) * (curX - x) + (curY - y) * (curY - y));
    }
}
