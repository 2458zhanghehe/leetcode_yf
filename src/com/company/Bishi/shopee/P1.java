package com.company.Bishi.shopee;

public class P1 {
    public ListNode removeNode(ListNode node, int n) {
        int len = 0;
        ListNode cur = node;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        cur = node;
        int step = len - n;
        if(step < 0){
            return node;
        }
        if(step == 0){
            return cur.next;
        }
        while(--step > 0){
            cur = cur.next;
        }
        ListNode next = cur.next.next;
        cur.next = next;
        return node;
    }

    class ListNode{
        public int val;
        public ListNode next;
    }
}
