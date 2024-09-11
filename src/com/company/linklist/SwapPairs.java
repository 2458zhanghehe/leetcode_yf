package com.company.linklist;

//leetcode 24 两两交换链表中的节点  即K个一组翻转链表中k = 2的情况
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode preNewEnd = null;
        ListNode curNewEnd = null;
        ListNode curNewStart = null;
        ListNode next = null;
        ListNode ans = head.next;

        while(head != null && head.next != null){
            curNewEnd = head;
            curNewStart = head.next;
            next = head.next.next;
            head.next.next = head;
            if(preNewEnd != null){
                preNewEnd.next = curNewStart;
            }
            preNewEnd = curNewEnd;
            head = next;
        }

        preNewEnd.next = head;

        return ans;
    }

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ans = swapPairs(head);
    }
}
