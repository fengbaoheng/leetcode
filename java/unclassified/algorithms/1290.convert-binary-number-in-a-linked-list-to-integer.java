/*
 * @lc app=leetcode.cn id=5283 lang=java
 *
 * [5283] 二进制链表转整数
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
class Solution {
    public int getDecimalValue(ListNode head) {
        int number = 0;

        while (head != null) {
            number = number << 1;
            if (head.val == 1) {
                number = number + 1;
            }

            head = head.next;
        }

        return number;
    }
}
// @lc code=end

