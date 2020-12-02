#
# @lc app=leetcode.cn id=876 lang=python3
#
# [876] 链表的中间结点
#


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 快慢指针
    def middleNode(self, head: ListNode) -> ListNode:
        try:
            if head is None:
                return None

            # 仅有一个节点
            if head.next is None:
                return head

            # 两个节点及以上
            low = head
            fast = head.next

            # 不考虑环形链表，因为环形没有中间节点
            while True:
                low = low.next

                if fast.next is not None and fast.next.next is not None:
                    fast = fast.next.next
                else:
                    # 快指针到达终点
                    break

            return low

        except:
            return None
