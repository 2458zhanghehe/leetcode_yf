package com.company.Bishi.baidu;
import java.util.*;
public class P1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(--t >= 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int k = sc.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(a);
            pq.add(b);
            pq.add(c);
            pq.add(d);
            while(--k >= 0){
                int small = pq.poll() + 1;
                pq.add(small);
            }

            long sum = 1L;
            while(!pq.isEmpty()){
                sum *= pq.poll();
            }
            System.out.println(sum);
        }
    }
}
