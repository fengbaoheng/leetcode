/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
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
import java.util.Random;

class Solution {
    private final ListNode head;
    private final Random random;

    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        ListNode cur = head;
        int count = 0;
        int result = 0;
        while (cur != null) {
            count++;
            if (random.nextInt(count) == 0) {
                result = cur.val;
            }
            cur = cur.next;
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

