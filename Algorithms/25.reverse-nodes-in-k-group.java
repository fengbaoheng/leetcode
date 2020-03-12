/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode reversed = new ListNode(-1);
        ListNode reversedTail = reversed;

        ListNode rest = head;

        while (true) {
            // 切割K个节点出来, 返回剩余节点
            ListNode[] separated = separate(rest, k);

            ListNode kHead = separated[0];
            rest = separated[1];

            // 剩余不足K个节点
            // 拼接剩余节点后返回
            if(kHead == null){
                reversedTail.next = rest;
                break;
            }


            // 反转k个节点, 返回反转后的头节点
            // 现在的kHead反转后变为kTail
            reversedTail.next = reverse(kHead);
            reversedTail = kHead;
        }


        return reversed.next;
    }

    /**
     * 拆分链表前K个节点和剩余所有节点
     *
     * @param head 链表
     * @param k    切割数量
     * @return 返回[前K, 剩余]
     */
    private ListNode[] separate(ListNode head, int k) {

        ListNode rest = head;

        // 遍历到倒数1个, 准备切割
        for (int i = 0; i < k - 1; i++) {
            if (rest == null) {
                break;
            }
            rest = rest.next;
        }

        // 不足K个节点
        if (rest == null) {
            return new ListNode[]{null, head};
        }

        ListNode result = rest.next;
        rest.next = null;
        return new ListNode[]{head, result};
    }

    /**
     * 反转链表
     *
     * @param head 链表头结点
     * @return 反转后的链表头结点
     */
    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
// @lc code=end

