package com.company.linklist;

//打印两个有序链表的公共部分
public class PrintSameInLinkList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void PrintSame(Node head1, Node head2) {
        Node help1 = head1;
        Node help2 = head2;
        while (help1 != null && help2 != null) {
            if (help1.value == help2.value) {
                System.out.println(help1.value);
                help1 = help1.next;
                help2 = help2.next;
            } else if (help1.value < help2.value) {
                help1 = help1.next;
            } else {
                help2 = help2.next;
            }
        }
    }

}
