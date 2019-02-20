/*
 * @lc app=leetcode.cn id=2 lang=csharp
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (31.87%)
 * Total Accepted:    80.7K
 * Total Submissions: 250.3K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
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
    private int AddNumWithCarry(int val1, int val2, ref int carry)
    {
        int sum = val1 + val2 + carry;
        if (sum >= 10)
        {
            carry = 1;
            sum = sum % 10;
        }
        else
        {
            carry = 0;
        }

        return sum;
    }

    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        var headNode = new ListNode(0);
        var curNode = headNode;

        int carry = 0;

        // 二者均有数位相加
        while (l1 != null && l2 != null)
        {
            int sum = AddNumWithCarry(l1.val, l2.val, ref carry);
            curNode.next = new ListNode(sum);

            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 一个数已经加完了
        if (l1 == null && l2 != null)
        {
            while (carry != 0 && l2 != null)
            {
                int sum = AddNumWithCarry(l2.val, 0, ref carry);
                curNode.next = new ListNode(sum);

                curNode = curNode.next;
                l2 = l2.next;
            }

            curNode.next = l2;
        }
        else if (l1 != null && l2 == null)
        {
            while (carry != 0 && l1 != null)
            {
                int sum = AddNumWithCarry(l1.val, 0, ref carry);
                curNode.next = new ListNode(sum);

                curNode = curNode.next;
                l1 = l1.next;
            }

            curNode.next = l1;
        }


        // 所有数加完后,看carry是否为1
        if (carry != 0)
        {
            curNode.next = new ListNode(carry);
        }

        return headNode.next;
    }
}
