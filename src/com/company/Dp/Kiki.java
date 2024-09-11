package com.company.Dp;

/*CC里面有一个土豪很喜欢一位女直播Kiki唱歌，平时就经常给她点赞、送礼、私聊。最近CC直播平台
在举行中秋之星主播唱歌比赛，假设一开始该女主播的初始人气值为start， 能够晋升下一轮人气需要
刚好达到end,土豪给主播增加人气的可以采取的方法有:

    a.点赞 花费 x C币 人气+2
    b.送礼 花费 y C币，人气*2
    c.私聊 花费 z C币，人气-2

其中 end 大于start,且end和start为偶数， 请写一个程序帮助豪计算一下，
最少花费多少C币就能帮助该主播Kiki将人气刚好达到end，从而能够晋级下一轮?
输入描述:
    第一行输入5个数据，分别为:x y z start end，每项数据以空格分开
    其中:0<x，y，z<=10000，0<start，end<=1000000
输出描述:需要花费的最少C币
示例1:
    输入
        3 100 1 2 6
    输出
        6
 */

public class Kiki {
    public static int Coins1(int x, int y, int z, int start, int end){
        return process1(x,y,z,start,end);
    }

    //不需要加curCoin参数
    // 这里因为有加有减会发生死循环，且纯减也是死循环。 需要找一个平常解增加限制
    private static int process1(int x, int y, int z, int start, int end) {
        if(start == end){
            return 0;
        }
        int p1 = process1(x, y, z,start + 2, end) + x;
        int p2 = process1(x, y, z, start * 2, end) + y;
        int p3 = process1(x, y, z, start - 2, end) + z;
        return Math.min(p1,Math.min(p2,p3));
    }


    public static int Coins2(int x, int y, int z, int start, int end){
        return process2(0, x, y, z, start, end, x * (end - start) / 2, 2*end);
    }

    // x * (end - start)/2 即为一个平凡解， 设为baseCase，大于时直接终止 这里需要增加CurCoin
    //另外，增加限制一直减到负数的情况
    //另外，比如 6 10 有可能先涨到12再减去2更划算，限制增长到 2 * aim即停止 （个人感觉非必要）
    private static int process2(int curCoin, int x, int y, int z, int cur,
                         int aim, int limitCoin, int limitAim) {
        if(cur == aim){
            return curCoin;
        }

        if(cur < 0){
            return Integer.MAX_VALUE;
        }

        if(curCoin > limitCoin){
            return Integer.MAX_VALUE;
        }

        if(cur > limitAim){
            return Integer.MAX_VALUE;
        }

        int p = Integer.MAX_VALUE;
        int p1 = process2(curCoin + x, x, y, z,cur + 2, aim, limitCoin, limitAim);
        if(p1 != Integer.MAX_VALUE){
            p = p1;
        }
        int p2 = process2(curCoin + y , x, y, z, cur * 2, aim, limitCoin, limitAim);
        if(p2 != Integer.MAX_VALUE){
            p = Math.min(p,p2);
        }
        int p3 = process2(curCoin + z, x, y, z, cur - 2, aim, limitCoin, limitAim);
        if(p3 != Integer.MAX_VALUE){
            p = Math.min(p,p3);
        }
        return p;
    }


    //process2的可变参数只有curCoin和cur
    public static int Coins3(int x, int y, int z, int start, int end){
        int[][] dp = new int[x * (end - start) / 2 + 1][2 * end + 1];

        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = 0; j < dp[0].length; j++){
                if(j == end){
                    dp[i][j] = i;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                if(i + x >= 0 && i + x < dp.length && j + 2 >= 0 && j + 2 < dp[0].length){
                    if(dp[i + x][j + 2] != Integer.MAX_VALUE){
                        min = dp[i + x][j + 2];
                    }
                }

                if(i + y >= 0 && i + y < dp.length && j * 2 >= 0 && j * 2 < dp[0].length){
                    if(dp[i + y][j * 2] != Integer.MAX_VALUE){
                        min = Math.min(min, dp[i + y][j * 2]);
                    }
                }

                if(i + z >= 0 && i + z < dp.length && j - 2 >= 0 && j - 2 < dp[0].length){
                    if(dp[i + z][j - 2] != Integer.MAX_VALUE){
                        min = Math.min(min, dp[i + z][j - 2]);
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[0][start];
    }

    public static void main(String[] args) {
        int nums2 = Coins2(3, 100, 1, 2, 6);
        System.out.println(nums2);

        int nums3 = Coins3(3, 100, 1, 2, 6);
        System.out.println(nums3);
    }
}
