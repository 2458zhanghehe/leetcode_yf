package com.company.linklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//leetcode 148 排序链表
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode H = head;
        ListNode T = head;
        ListNode cur = head.next;
        while(cur != null){
            ListNode next = cur.next;
            if(cur.val <= H.val){
                cur.next = H;
                H = cur;
            }else if(cur.val >= T.val){
                T.next = cur;
                T = cur;
            }else {
                ListNode cur1 = H;
                while(cur.val > cur1.next.val){
                    cur1 = cur1.next;
                }
                ListNode tmp = cur1.next;
                cur1.next = cur;
                cur.next = tmp;
            }
            cur = next;
        }
        T.next = null;
        return H;
    }

    public static ListNode sortList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }

        Collections.sort(list, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        head = list.get(0);
        ListNode cur = head;
        for(int i = 1; i < list.size(); i++){
            cur.next = list.get(i);
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

//    public static class MyComparator implements Comparator<ListNode>{
//
//        @Override
//        public int compare(ListNode o1, ListNode o2) {
//            return o1.val - o2.val;
//        }
//    }


    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(3);
//        sortList(head);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.get(0));
    }

}
