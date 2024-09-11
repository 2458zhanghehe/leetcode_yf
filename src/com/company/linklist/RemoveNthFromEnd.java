package com.company.linklist;

public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }

        if(len == n){
            return head.next;
        }

        ListNode pre = null;
        ListNode next = null;
        cur = head;
        while(len > 0){
            if(len == n + 1){
                pre = cur;
            }
            if(len == n - 1){
                next = cur;
            }
            cur = cur.next;
            len--;
        }
        pre.next = next;

        return head;
    }
}
