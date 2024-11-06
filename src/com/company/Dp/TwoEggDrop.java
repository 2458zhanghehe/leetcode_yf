package com.company.Dp;

// 1884 鸡蛋掉落
public class TwoEggDrop {
    //方法一：公式推导法
    //均匀法：比如100层分成10组，第一个鸡蛋从第一组开始，逐组试探，确定在哪个组
    //       第二个鸡蛋在这组里从低往下试探。 最好：第一组第十层，则 1 + 9 = 10次，最差：第100层，则10 + 9 =19次
    //想要最差情况尽可能小，则希望各组的试探次数尽量均衡，所以组别试探每加1，组内试探就减1。 假设第一组组内试探y（把组的
    // 一次试探直接算进组内），则第二组试探y - 1，...  y + y - 1 + y - 2 + ... + (y - m) >= n。求解不等式方程;
    public int twoEggDrop1(int n) {
        return (int)Math.ceil((Math.sqrt(8 * n) - 1) / 2);
    }

    //方法二：递归 + 记忆缓存
    private static int[] memory = new int[10000];
    public int twoEggDrop2(int n) {
        if(n == 0){
            return 0;
        }
        if(memory[n] > 0){
            return memory[n];
        }
        int curAns = Integer.MAX_VALUE;
        //从第一层到第n层逐层试，找到最少尝试次数
        //对于第i层，如果破了，则需要从第一层到i - 1层逐层尝试，也就是(i - 1) + 1
        //如果没破，则需要用两个鸡蛋找到从（i + 1）层到n层的最小尝试次数，等价于1层到n - 1层，也就是f(n - i) + 1
        //在第一次在i层抛的前提下，不管哪种情况都需要确定层数，所以取二者较大值
        for (int i = 1; i <= n; i++) {
            curAns = Math.min(curAns, Math.max(i, twoEggDrop2(n - i) + 1));
        }
        memory[n] = curAns;
        return curAns;
    }

    //方法三 dp
    public int twoEggDrop3(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int curAns = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                curAns = Math.min(curAns, Math.max(j, dp[i - j] + 1));
            }
            dp[i] = curAns;
        }
        return dp[n];
    }
}
