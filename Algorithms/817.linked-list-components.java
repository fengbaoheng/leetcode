/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
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
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }

        int count = 0;
        boolean isContinue = false;

        while (head != null) {
            int num = head.val;

            if (set.contains(num)) {
                isContinue = true;
            } else if (isContinue) {
                // 中断
                isContinue = false;
                count++;
            }

            head = head.next;
        }

        if (isContinue) {
            count++;
        }

        return count;
    }
}
// @lc code=end

