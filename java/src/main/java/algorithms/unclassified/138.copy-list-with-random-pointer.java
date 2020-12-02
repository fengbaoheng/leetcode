/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        int size = getSize(head);
        Node[] clone = cloneArray(head, size);

        Map<Node, Integer> indexMap = getIndexMap(head);
        for (int i = 0; i < size; i++) {
            Node random = head.random;
            if (random != null) {
                int index = indexMap.get(random);
                clone[i].random = clone[index];
            }
            head = head.next;
        }

        return clone[0];
    }

    private int getSize(Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private Map<Node, Integer> getIndexMap(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            map.put(head, index);
            index++;
            head = head.next;
        }
        return map;
    }

    private Node[] cloneArray(Node head, int size) {
        Node[] clone = new Node[size];

        for (int i = 0; i < size; i++) {
            clone[i] = new Node(head.val);
            head = head.next;
        }

        for (int i = 0; i < size - 1; i++) {
            clone[i].next = clone[i + 1];
        }

        return clone;
    }


}
// @lc code=end

