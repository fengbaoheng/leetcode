package algorithms;

import core.ListNode;

/**
 * 1721.交换链表中的节点
 */

class Problem1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // 快慢指针，快指针与慢指针保持k距离
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        // 此时快指针就停留在第一个交换节点上
        ListNode first = fast;

        // 快慢指针同步前进，直到快指针移动到链表末尾
        ListNode low = head;
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }

        // 此时的慢指针就指向了第二个交换节点上
        ListNode last = low;

        // 交换节点值
        int temp = last.val;
        last.val = first.val;
        first.val = temp;

        return head;
    }
}

