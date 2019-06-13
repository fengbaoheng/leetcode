#
# @lc app=leetcode.cn id=328 lang=python3
#
# [328] 奇偶链表
#
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 使用两个指针分别指向剩余链表的奇节点和偶节点
    # 注意判断特殊条件和尾节点next为null
    def oddEvenList(self, head: ListNode) -> ListNode:
        # 空链表 或仅有1, 2个节点的链表无需操作
        if head is None or head.next is None or head.next.next is None:
            return head

        # 此时至少有3个节点
        odd = head
        even = head.next

        # 记录偶链表的头部用于奇偶链表合并
        even_head = head.next

        # 迭代
        while even.next and even.next.next:
            odd.next = even.next
            even.next = even.next.next

            odd = odd.next
            even = even.next

        # 迭代的结束的两种情况

        # 最后一个节点是偶数
        # 奇数节点=偶数节点 正好对半分
        if even.next is None:
            odd.next = even_head

        # 最后一个节点是奇数
        # 连接最后一个奇数节点
        # 注意最后一个偶数节点的next指针应设为None, 否则会出现环
        else:
            odd.next = even.next
            even.next = None
            odd.next.next = even_head

        return head

