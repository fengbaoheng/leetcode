#
# @lc app=leetcode.cn id=24 lang=python3
#
# [24] 两两交换链表中的节点
#
# https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
#
# algorithms
# Medium (58.89%)
# Total Accepted:    18.4K
# Total Submissions: 31.2K
# Testcase Example:  '[1,2,3,4]'
#
# 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
# 
# 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
# 
# 
# 
# 示例:
# 
# 给定 1->2->3->4, 你应该返回 2->1->4->3.
# 
# 
#
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        # 取出前两个(如果有)交换
        # 再将剩余的链表交换
        # 二者拼接即可

        if head is None:
            return None
        
        # 只剩一个节点
        if head.next is None:
            return head

        # 拥有至少两个节点
        rest = head.next.next

        new_head = head.next
        new_head.next = head
        head.next = self.swapPairs(rest)

        return new_head
        

