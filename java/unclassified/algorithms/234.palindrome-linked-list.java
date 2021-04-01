/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode back = split(head);
        back = reverse(back);

        return isSame(head, back);
    }

    // 使用快慢指针将链表拆分为等长的两部分
    // 即长度为奇数时, 去除最中间的部分
    private ListNode split(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode low = head;
        ListNode fast = head.next;

        while (fast.next != null && fast.next.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        ListNode back = fast.next == null ? low.next : low.next.next;
        low.next = null;

        return back;
    }

    // 反转链表
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head;
        head = head.next;
        newHead.next = null; // 头节点变尾节点

        while (head != null) {
            ListNode curNode = head;
            head = head.next;
            curNode.next = newHead;
            newHead = curNode;
        }

        return newHead;
    }

    // 判断两链表是否相等
    private boolean isSame(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        // 两个链表是否等长度
        return head1 == null && head2 == null;

    }
}

