package com.company.linklist;

import java.util.Stack;

//leetcode 234 回文链表
public class IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //需要n个额外空间
    public static boolean isPaLindromel1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //need n/2 extra space   使用快慢指针
    public static boolean isPaLindromel2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    //need O(1) extra space
    public static boolean isPalindromel3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        Node n3 = null;
        while (fast != null) {
            n3 = fast.next;
            fast.next = slow;
            slow = fast;
            fast = n3;
        }
        n3 = slow;  //n3:save the last node
        fast = head;
        boolean res = true;
        while (slow != null && fast != null) {
            if (slow.value != fast.value) {
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = n3.next;
        n3.next = null;
        while (slow != null) {
            fast = slow.next;
            slow.next = n3;
            n3 = slow;
            slow = fast;
        }
        return res;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List:");
        while (head != null) {
            System.out.print(head.value + "  ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPaLindromel1(head) + " | ");
        System.out.print(isPaLindromel2(head) + " | ");
        System.out.print(isPalindromel3(head) + " | ");
        System.out.println("");
        printLinkedList(head);
        System.out.println("==================================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPaLindromel1(head) + " | ");
        System.out.print(isPaLindromel2(head) + " | ");
        System.out.print(isPalindromel3(head) + " | ");
        System.out.println("");
        printLinkedList(head);
        System.out.println("==================================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(100);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPaLindromel1(head) + " | ");
        System.out.print(isPaLindromel2(head) + " | ");
        System.out.print(isPalindromel3(head) + " | ");
        System.out.println("");
        printLinkedList(head);
        System.out.println("==================================");
    }


}
