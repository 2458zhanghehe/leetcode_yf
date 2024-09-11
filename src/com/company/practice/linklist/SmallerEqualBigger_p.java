package com.company.practice.linklist;

import com.company.linklist.SmallEqualBigger;

public class SmallerEqualBigger_p {

    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static Node listPartition1_p(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, index, --big);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2_p(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node SH = null;
        Node ST = null;
        Node EH = null;
        Node ET = null;
        Node BH = null;
        Node BT = null;
        while (head != null) {
            if (head.value < pivot) {
                if (SH == null) {
                    SH = head;
                    ST = head;
                } else {
                    ST.next = head;
                    ST = ST.next;
                }
            } else if (head.value == pivot) {
                if (EH == null) {
                    EH = head;
                    ET = head;
                } else {
                    ET.next = head;
                    ET = ET.next;
                }
            } else {
                if (BH == null) {
                    BH = head;
                    BT = head;
                } else {
                    BT.next = head;
                    BT = BT.next;
                }
            }
            head = head.next;
        }
        //先吧三段链表连起来，不考虑头在哪里
        if (ST != null) {
            ST.next = EH;
            ET = (ET == null) ? ST : ET;
        }
        if (ET != null) {
            ET.next = BH;
        }
        return SH != null ? SH : (EH != null ? EH : BH);
    }


}
