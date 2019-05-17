#
# @lc app=leetcode.cn id=92 lang=python3
#
# [92] 反转链表 II
#
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 快慢指针确定链表范围
    # 链表分为三部分 前+反转+后
    # 将反转部分的链表头逐个链接到后链表头部即可
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        try:
            if head is None or m < 1 or n < m:
                return None
            if m == n:
                return head

            # 临时头结点,链表可能从头开始反转
            tmp_head = ListNode(0)
            tmp_head.next = head

            # 快指针先走n-m步
            steps = n - m + 1
            fast = tmp_head
            while steps > 0:
                # 快指针是否到了链表尾部
                if fast is not None:
                    fast = fast.next
                steps -= 1

            # 快慢指针再同时走m-1步后
            # low.next即是反转链表的头部
            # fast是反转链表的尾部
            steps = m - 1
            slow = tmp_head
            while steps > 0:
                if fast is not None:
                    fast = fast.next
                slow = slow.next
                steps -= 1

            # 拆分链表为三部分
            back_list_head = fast.next
            fast.next = None

            reverse_list_head = slow.next
            slow.next = None

            # 逐个反转
            # reverse_list_head插入到back_list_head前
            while reverse_list_head is not None:
                node = reverse_list_head
                reverse_list_head = reverse_list_head.next

                node.next = back_list_head
                back_list_head = node

            # 链表合并
            # 此时 reverse_list全部插入到了back_list中
            slow.next = back_list_head

            return tmp_head.next

        except Exception as e:
            raise e

