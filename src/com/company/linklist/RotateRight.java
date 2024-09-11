package com.company.linklist;

public class RotateRight {
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

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }

        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }

        cur = head;
        ListNode end = null;
        ListNode start = null;
        k = k % len;
        if(k == 0){
            return head;
        }
        while(len > 0){
            if(len == k + 1){
                end = cur;
            }
            if(len == k){
                start = cur;
            }
            if(len == 1){
                cur.next = head;
                break;
            }
            cur = cur.next;
            len--;
        }
        end.next = null;
        return start;
    }
}
