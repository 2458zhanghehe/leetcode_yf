package com.company.Bishi.Huawei.Day0821;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> tasks = new ArrayList<>();
        ArrayList<Integer> machines = new ArrayList<>();
        int[] machineRest = new int[3];
        for (int i = 0; i < n; i++) {
            tasks.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            machines.add(cur);
            machineRest[cur]++;
        }


        while(!tasks.isEmpty()){
            Integer curTask = tasks.get(0);
            Integer curMachine = machines.get(0);
            if(Objects.equals(curTask, curMachine)){
                tasks.remove(0);
                machines.remove(0);
                machineRest[curTask]--;
            }else if(curTask == 0){
                boolean ok = process(0, machineRest, tasks, machines);
                if(!ok){
                    break;
                }
            }else if(curTask == 1){
                boolean ok = process(1, machineRest, tasks, machines);
                if(!ok){
                    break;
                }
            }
        }
        System.out.println(machines.size());
    }

    private static boolean process(int target, int[] machineRest, List<Integer> tasks, List<Integer> machines){
        if(machineRest[target] > 0){
            while(machines.get(0) != target){
                Integer tmp = machines.get(0);
                machines.remove(0);
                machines.add(tmp);
            }
            tasks.remove(0);
            machines.remove(0);
            machineRest[target]--;
        }else if(machineRest[2] == 0){
            return false;
        }else if(machineRest[2] > 0){
            for (int i = 0; i < machines.size(); i++) {
                if(machines.get(i) == 2){
                    machines.set(i, target);
                    machineRest[target]++;
                }
            }
            machineRest[2] = 0;
        }
        return true;
    }
}
