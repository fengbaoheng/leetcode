/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur = head;

        while (cur != null) {
            if (cur.child != null) {
                // 保存原始next
                Node rawNext = cur.next;

                // 处理子链表节点
                Node childHead = flatten(cur.child);
                cur.child = null;

                // 将子链表插入next
                cur.next = childHead;
                childHead.prev = cur;

                // 向后搜索到新的尾节点
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = rawNext;
                if (rawNext != null) {
                    rawNext.prev = cur;
                }

            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
// @lc code=end

