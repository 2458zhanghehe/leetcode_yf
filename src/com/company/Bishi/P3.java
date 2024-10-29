package com.company.Bishi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chars = str.toCharArray();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '/'){
                if(!deque.isEmpty() && deque.peekFirst() == '/'){
                    continue;
                }
                deque.addFirst(chars[i]);
            }else if(chars[i] == '.'){
                if(i + 1 == chars.length || chars[i + 1] != '.'){
                    deque.pollFirst();
                }else if(chars[i + 1] == '.'){
                    deque.pollFirst();
                    while(!deque.isEmpty() && deque.peekFirst() != '/'){
                        deque.pollFirst();
                    }
                    deque.pollFirst();
                    i++;
                }
            }else{
                deque.addFirst(chars[i]);
            }
        }
        while(!deque.isEmpty() && deque.peekFirst() == '/'){
            deque.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        System.out.println(sb.toString());
    }
}
