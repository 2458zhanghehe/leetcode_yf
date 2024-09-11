package com.company.Bishi.ant.Day0423;

import java.util.ArrayList;
import java.util.List;

public class P2 {
    private static int MinOps(int num){
        String numStr = String.valueOf(num);
        List<Integer> list = new ArrayList<>();
        process(0, numStr.length(), 0, list, 1);

        int k = 1;
        int ans = 0;
        while(num > 1){
            boolean flag = false;
            for(Integer tmp : list){
                if(num % tmp == 0){
                    if(tmp == 1){
                        continue;
                    }
                    num = num / tmp;
                    numStr = String.valueOf(num);
                    list.clear();
                    process(0,numStr.length(),0,list,1);
                    ans++;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                if(numStr.length() <= k){
                    break;
                }
                list.clear();
                process(0, numStr.length() - k, 0 , list, 1);
                k++;
            }
        }

        if(num == 1){
            return ans;
        }else{
            return -1;
        }

    }

    private static void process(int index, int len, int cur, List<Integer> list, int bei) {
        if(index == len){
            list.add(cur);
            return;
        }
        process(index + 1, len, cur + bei, list, bei * 10);
        process(index + 1, len, cur + bei * 2, list, bei * 10);
    }

    public static void main(String[] args) {
        int ans = MinOps(111112);
        System.out.println(ans);
    }
}
