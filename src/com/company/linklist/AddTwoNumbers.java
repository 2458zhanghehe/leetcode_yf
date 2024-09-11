package com.company.linklist;

//leetcode 2
public class AddTwoNumbers {
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = l1.val;
        long help = 10;
        while(l1.next != null){
            l1 = l1.next;
            num1 += help* l1.val;
            help *= 10;
        }
        long num2 = l2.val;
        help = 10;
        while(l2.next != null){
            l2 = l2.next;
            num2 += help * l2.val;
            help *= 10;
        }
        long num = num1 + num2;

        if(num == 0){
            return new ListNode(0);
        }

        ListNode head = null;
        ListNode ans = null;
        while(num > 0){
            int mod = (int) (num % 10);
            num = num / 10;

            ListNode cur = new ListNode(mod);
            if(head == null){
                head = cur;
                ans = cur;
            }else {
                head.next = cur;
                head = head.next;
            }
        }
        return ans;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode head = null;
        boolean flag = false;
        int curVal = l1.val + l2.val;
        if(curVal >= 10){
            flag = true;
        }
        head = new ListNode(curVal % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode ans = head;
        while(l1 != null && l2 != null){
            curVal = l1.val + l2.val + ((flag == true) ? 1 :0);
            flag = false;
            if(curVal >= 10){
                flag = true;
            }
            head.next = new ListNode(curVal % 10);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            curVal = l1.val + ((flag == true) ? 1 :0);
            flag = false;
            if(curVal >= 10){
                flag = true;
            }
            head.next = new ListNode(curVal % 10);
            head = head.next;
            l1 = l1.next;
        }

        while(l2 != null){
            curVal = l2.val + ((flag == true) ? 1 :0);
            flag = false;
            if(curVal >= 10){
                flag = true;
            }
            head.next = new ListNode(curVal % 10);
            head = head.next;
            l2 = l2.next;
        }
        if(flag == true){
            head.next = new ListNode(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);


        ListNode listNode = addTwoNumbers(l1, l2);


    }
}
