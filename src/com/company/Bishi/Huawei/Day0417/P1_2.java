package com.company.Bishi.Huawei.Day0417;

import java.util.*;
import java.util.stream.Collectors;

public class P1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String[] splits = str.split(" ");
        List<String> list = Arrays.stream(splits).collect(Collectors.toList());

        while(true){
            boolean flag = true;
            for(int i = 0; i < list.size() - 2; i++){
                String cur1 = list.get(i);
                String cur2 = list.get(i + 1);
                String cur3 = list.get(i + 2);
                if(cur1.equals(cur2) && cur2.equals(cur3)){
                    list.remove(cur1);
                    list.remove(cur2);
                    list.remove(cur3);
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        if(list.size() == 0){
            System.out.println(0);
        }else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }

    }
}
