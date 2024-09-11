package com.company.Bishi.SXF;

import java.util.HashMap;
import java.util.Scanner;
public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        String[] strAs = strA.split(" ");
        String[] strBs = strB.split(" ");
        int[] numsA = new int[strAs.length];
        int[] numsB = new int[strBs.length];
        for (int i = 0; i < numsA.length; i++) {
            numsA[i] = Integer.valueOf(strAs[i]);
        }
        for (int i = 0; i < numsB.length; i++) {
            numsB[i] = Integer.valueOf(strBs[i]);
        }
        //delta : index
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int sum = 0;
        while(i < numsA.length && i < numsB.length){
            int delta = numsB[i] - numsA[i];
            sum += delta;
            if(delta != 0 && !map.containsKey(delta)){
                map.put(delta, i);
            }
            i++;
        }

        while(i < numsA.length){
            sum -= numsA[i++];
        }

        while(i < numsB.length){
            sum += numsB[i++];
        }

        if(map.containsKey(sum / 2)){
            Integer index = map.get(sum / 2);
            System.out.println(numsA[index] + " " + numsB[index]);
        }else {
            System.out.println("fail");
        }
    }
}
