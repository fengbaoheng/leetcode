/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private int carry = 0;
    private ListNode head = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = getStack(l1);
        Deque<Integer> s2 = getStack(l2);

        head = null;
        carry = 0;

        while (s1.size() + s2.size() > 0) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            addDigit(sum(a, b));
        }

        if (carry == 1) {
            addDigit(1);
        }

        return head;
    }

    private Deque<Integer> getStack(ListNode node) {
        Deque<Integer> stack = new LinkedList<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        return stack;
    }

    private int sum(int a, int b) {
        int value = a + b + carry;
        carry = 0;

        if (value >= 10) {
            value %= 10;
            carry = 1;
        }

        return value;
    }

    private void addDigit(int value) {
        ListNode newHead = new ListNode(value);
        newHead.next = head;
        head = newHead;
    }
}
// @lc code=end

