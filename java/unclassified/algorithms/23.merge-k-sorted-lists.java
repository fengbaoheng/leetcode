/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
import java.util.*;

class Solution {
    // 使用优先队列queue记录所有链表
    // 取出queue的首个链表curList进行节点提取并重新排列
    // 循环提取curList节点, 直到curList头部节点大于queue的首个链表的头部节点
    // 将curList插入queue,并重新步骤2
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }

        // 按节点值排序的优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        // 重排后的链表
        ListNode tmp = new ListNode(-1);
        ListNode curNode = tmp;

        while (!queue.isEmpty()) {
            ListNode curList = queue.poll();

            // 取出的是最后一条链表
            if (queue.isEmpty()) {
                curNode.next = curList;
                break;
            }

            // 循环重排curList, 直到其值大于first.val
            while (curList != null && curList.val <= queue.peek().val) {
                curNode.next = curList;
                curNode = curNode.next;

                curList = curList.next;

                curNode.next = null;
            }

            // 重新插回queue
            if (curList != null) {
                queue.add(curList);
            }
        }


        return tmp.next;
    }
}
// @lc code=end

