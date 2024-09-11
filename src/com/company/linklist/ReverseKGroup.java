package com.company.linklist;

import java.util.List;

//leetcode 25  k个一组翻转链表
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 1;
        ListNode cur = head;
        ListNode ans = null;
        while(cur.next != null){
            cur = cur.next;
            len++;
            if(len == k){
                ans = cur;
            }
        }
        if(len < k || k == 1){
            return head;
        }

        cur = head;
        ListNode curNewEnd;
        ListNode next = null;
        ListNode pre = null;
        ListNode preNewEnd = null;
        int i = 0;
        for (; i + k - 1 < len; i += k) {
            int count = 0;
            curNewEnd = cur;
            while(++count <= k){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if(preNewEnd != null){
                preNewEnd.next = pre;
                preNewEnd = curNewEnd;
            }else {
                preNewEnd = curNewEnd;
            }
            pre = null;
        }

        if(i != len && preNewEnd != null){
            preNewEnd.next = next;
        }
        return ans;
    }


    class ListNode {
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
}
