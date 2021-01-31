package core;

import java.util.List;

public class ListNode {
    static ListNode from(List<Integer> nodes) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        for (Integer nodeVal : nodes) {
            tail.next = new ListNode(nodeVal);
            tail = tail.next;
        }

        return head.next;
    }

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }
}
