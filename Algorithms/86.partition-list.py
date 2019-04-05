#
# @lc app=leetcode.cn id=86 lang=python3
#
# [86] 分隔链表
#
# https://leetcode-cn.com/problems/partition-list/description/
#
# algorithms
# Medium (43.73%)
# Total Accepted:    6.5K
# Total Submissions: 13.9K
# Testcase Example:  '[1,4,3,2,5,2]\n3'
#
# 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
# 
# 你应当保留两个分区中每个节点的初始相对位置。
# 
# 示例:
# 
# 输入: head = 1->4->3->2->5->2, x = 3
# 输出: 1->2->2->4->3->5
# 
# 
#
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        # 维持两个链表分别存储左侧和右侧节点，最后合并
        left_head = ListNode(-1)
        right_head = ListNode(-1)
        
        left_cur = left_head
        right_cur = right_head
        
        # 分割排序
        cur = head
        while cur:
            cur_next = cur.next
            if cur.val < x:
                left_cur.next = cur
                # 及时切断尾巴
                left_cur = cur
                left_cur.next = None
            else:
                right_cur.next = cur
                
                right_cur = cur
                right_cur.next = None
                
            cur = cur_next
                     
        # 合并链表
        left_cur.next = right_head.next
        return left_head.next
        

