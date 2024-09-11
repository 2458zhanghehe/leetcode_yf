package com.company.practice.linklist;

import com.company.linklist.PrintSameInLinkList;

public class PrintSameInLinkList_p {

    public static class Node {
        public int val;
        public Node next;

        public Node(int v) {
            val = v;
        }
    }

    public static void PrintSame(PrintSameInLinkList.Node head1, PrintSameInLinkList.Node head2) {
        PrintSameInLinkList.Node help1 = head1;
        PrintSameInLinkList.Node help2 = head2;
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
