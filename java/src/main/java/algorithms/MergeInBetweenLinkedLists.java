package algorithms;

/**
 * 1669.合并两个链表
 */
class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode beforeA = findByIndex(list1, a - 1);
        ListNode B = findByIndex(beforeA, 1 + b - a);
        ListNode end2 = findEnd(list2);

        beforeA.next = list2;
        end2.next = B.next;
        B.next = null;

        return list1;
    }

    private ListNode findByIndex(ListNode list, int index) {
        for (int i = 0; i < index; i++) {
            list = list.next;
        }
        return list;
    }

    private ListNode findEnd(ListNode list) {
        while (list.next != null) {
            list = list.next;
        }
        return list;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
