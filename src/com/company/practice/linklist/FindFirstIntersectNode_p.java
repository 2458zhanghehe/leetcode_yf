package com.company.practice.linklist;

import com.company.linklist.FindFirstIntersectNode;

public class FindFirstIntersectNode_p {

    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    public static Node isLoop(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node s = head.next;
        Node f = head.next.next;
        while (s != f && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        if (s != f) {
            return null;
        }
        f = head;
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return f;
    }

    public static Node findFirstIntersectNode_p(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node loop1 = isLoop(head1);
        Node loop2 = isLoop(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return boothLoop(head1, head2, loop1, loop2);
        } else {
            return null;
        }
    }

    //如果两链表都无环，返回第一个相交的节点，如果不相交，返回null
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node boothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        if (loop1 != loop2) {
            return loop1;
        }

        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1 != loop1) {
            cur1 = cur1.next;
            n++;
        }
        while (cur2 != loop2) {
            cur2 = cur2.next;
            n--;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n > 0) {
            cur1 = cur1.next;
            n--;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
