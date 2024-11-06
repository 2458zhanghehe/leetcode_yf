package com.company.math;

public class TakeStones {
    //取石子游戏：一共有N颗石子，每次最多取M颗最少取1颗，A，B轮流取，谁先取完谁获胜，输出获胜者名字（假设他们每次都取最优解），假设A先取
    //简单的*******bash博弈**********
    //（1）如果N <= M。则A直接全部取完获胜
    //（2）如果 N > M，则A想要获胜需要保证它倒数第二次取完后还剩M + 1个石头，则B取1到M必然取不完且剩余的A一定一次取得完
    //要保证这个条件，需要 N % (M + 1)不等于0，则第一次A取余数，往后B取k，则A取M + 1 - k，即可。相反，如果 N % (M + 1) == 0
    //则A不管怎么取k，B都取M + 1 - k保证自己一定获胜。

    public String takeStonesGame(int N, int M){
        if(N <= M){
            return "A";
        }
        if(N % (M + 1) != 0){
            return "A";
        }else {
            return "B";
        }
    }
}
