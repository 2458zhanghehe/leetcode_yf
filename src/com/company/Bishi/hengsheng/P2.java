package com.company.Bishi.hengsheng;
import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        int size = 2;
        int preTime = -1;
        for(int i = 0; i < n; i++){
            boolean flag = false;
            int time = sc.nextInt();
            int price = sc.nextInt();
            if(list.size() == size){
                int min = findMin(list);
                //错误，第n分钟可能会有多个输入，不能一上来就判断。
                //应该先处理完所有输入再写算法！！！
                if(price > min + 5){
                    flag = true;
                }
            }

            if(preTime == time && list.peekFirst() > price){
                list.pollFirst();
                list.addFirst(price);
            }else if(list.size() == size){
                list.pollLast();
                list.addFirst(price);
            }else {
                list.addFirst(price);
            }

            preTime = time;
            if(i + 1 <= 2){
                System.out.println((i + 1) + " N");
            }else {
                System.out.println((i + 1) + (flag ? " Y" : " N"));
            }
        }
    }

    private static int findMin(LinkedList<Integer> list) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++){
            min = Math.min(min,list.get(i));
        }
        return min;
    }
}
