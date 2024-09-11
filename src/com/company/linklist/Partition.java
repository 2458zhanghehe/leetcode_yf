package com.company.linklist;

public class Partition {

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


    public static ListNode partition(ListNode head, int pivot) {
        ListNode sH = null;  //small head
        ListNode sT = null;  //small tail

        ListNode mH = null;  //big head
        ListNode mT = null;  //big tail
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else {
                if (mH == null) {
                    mH = head;
                    mT = head;
                } else {
                    mT.next = head;
                    mT = head;
                }
            }
            head = next;
        }

        if (sT != null) {
            sT.next = mH;

        }
        return sH != null ? sH : mH;
    }
}
