package com.company.Bishi.vivo;

public class P1 {

    public int staffGroup (int[] staff) {
        int oldE = 0;
        int newE = 0;
        for(int cur : staff){
            if(cur == 1){
                oldE++;
            } else if (cur == 0) {
                newE++;
            }
        }
        int ans = 0;
        ans = oldE;
        if(oldE < newE){
            newE -= oldE;
            ans += newE / 3 + ((newE % 3 != 0) ? 1 : 0);
        }
        return ans;
    }

    public static void main(String[] args) {


    }
}
