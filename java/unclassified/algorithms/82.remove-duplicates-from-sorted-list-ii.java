/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-1);
        ListNode tail = temp;

        while (head != null) {
            // 找到下一个不重复的头结点
            // 即如果头结点重复就删除
            while (isDuplicate(head)) {
                head = deleteNumber(head);
            }

            if (head == null) {
                break;
            }

            tail.next = head;
            tail = tail.next;

            head = head.next;
            tail.next = null;
        }

        return temp.next;
    }


    // 当前头结点是否重复的
    private boolean isDuplicate(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        return head.val == head.next.val;
    }

    // 删除当前重复的头结点
    private ListNode deleteNumber(ListNode head) {
        if (head == null) {
            return head;
        }

        int deletedNumber = head.val;
        while (head != null && head.val == deletedNumber) {
            head = head.next;
        }

        return head;
    }

}

