#
# @lc app=leetcode.cn id=61 lang=python3
#
# [61] 旋转链表
#
# https://leetcode-cn.com/problems/rotate-list/description/
#
# algorithms
# Medium (37.66%)
# Total Accepted:    13.2K
# Total Submissions: 35K
# Testcase Example:  '[1,2,3,4,5]\n2'
#
# 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1:
#
# 输入: 1->2->3->4->5->NULL, k = 2
# 输出: 4->5->1->2->3->NULL
# 解释:
# 向右旋转 1 步: 5->1->2->3->4->NULL
# 向右旋转 2 步: 4->5->1->2->3->NULL
#
#
# 示例 2:
#
# 输入: 0->1->2->NULL, k = 4
# 输出: 2->0->1->NULL
# 解释:
# 向右旋转 1 步: 2->0->1->NULL
# 向右旋转 2 步: 1->2->0->NULL
# 向右旋转 3 步: 0->1->2->NULL
# 向右旋转 4 步: 2->0->1->NULL
#
#
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 先计算链表总长n, 对k取余得余数m
    # 联接链表尾部和头部形成环形链表
    # 在head后的n-m-1个节点处打断链表, 返回新的头部节点即可
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head is None:
            return None

        if k <= 0:
            return head

        n = 1
        cur: ListNode = head
        while cur.next:
            cur = cur.next
            n += 1

        # 此时cur为链表末尾
        # 将其与头部链接,形成环形链表
        cur.next = head

        m = k % n
        cur = head
        for i in range(n - m - 1):
            cur = cur.next

        new_head = cur.next
        cur.next = None

        return new_head

