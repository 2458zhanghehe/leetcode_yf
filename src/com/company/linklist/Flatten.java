package com.company.linklist;

//leetcode 430 扁平化多级双向链表
public class Flatten {
    public static Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        process(cur);
        return head;
    }
    public static Node process(Node cur) {
        while(cur.next != null || cur.child != null){
            if(cur.child != null){
                Node next = cur.next;
                Node end = process(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                end.next = next;
                if(next != null){
                    next.prev = end;
                }
            }
            cur = cur.next;
        }
        return cur;
    }


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    public static void main(String[] args) {

    }
}
