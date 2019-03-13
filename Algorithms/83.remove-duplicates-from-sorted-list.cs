/*
 * @lc app=leetcode.cn id=83 lang=csharp
 *
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * algorithms
 * Easy (43.09%)
 * Total Accepted:    16.5K
 * Total Submissions: 37.7K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2
 * 输出: 1->2
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode DeleteDuplicates(ListNode head)
    {
        if (head == null) { return null; }

        var curNode = head;
        while (curNode.next != null)
        {
            var curValue = curNode.val;
            var nextNode = curNode.next;
            var nextValue = nextNode.val;

            if (curValue == nextValue)
            {
                curNode.next = nextNode.next;
            }
            else
            {
                curNode = nextNode;
            }
        }
        return head;
    }
}
