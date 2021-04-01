import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

// @lc code=start
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int[] counts = getCounts(root, k);

        ListNode[] results = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode rest = split(root, counts[i]);
            results[i] = root;
            root = rest;
        }

        return results;
    }

    /**
     * 计算每段链表长度
     */
    private int[] getCounts(ListNode root, int k) {
        int count = getCount(root);

        int[] counts = new int[k];
        Arrays.fill(counts, count / k);

        for (int i = 0; i < count % k; i++) {
            counts[i]++;
        }

        return counts;
    }

    /**
     * 计算链表长度
     */
    private int getCount(ListNode root) {
        int count = 0;

        while (root != null) {
            count++;
            root = root.next;
        }

        return count;
    }

    /**
     * 分隔链表
     */
    private ListNode split(ListNode root, int count) {
        if (root == null || count == 0) {
            return null;
        }

        // 找到第count-1个节点
        ListNode head = root;
        while (count > 1 && head != null) {
            head = head.next;
            count--;
        }

        // 分隔
        ListNode rest = head.next;
        head.next = null;

        return rest;
    }
}
// @lc code=end
