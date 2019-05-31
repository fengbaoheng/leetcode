#
# @lc app=leetcode.cn id=148 lang=python3
#
# [148] 排序链表
#
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        elif head.next is None:
            return head
        elif head.next.next is None:
            if head.next.val < head.val:
                head.next.next = head
                head = head.next
                head.next.next = None
            return head

        # 拆分两个链表
        backend = self.split_list(head)

        # 每个链表分别排序
        head = self.sortList(head)
        backend = self.sortList(backend)

        # 合并两个有序链表
        return self.merge_list(head, backend)

    # 将链表拆分为两部分, 返回后半部分的头节点
    # 使用快慢指针从中间斩断
    def split_list(self, head: ListNode) -> ListNode:
        # 单节点链表无需拆分
        if head is None or head.next is None:
            return None
        # 只有两个节点
        elif head.next.next is None:
            node = head.next
            head.next = None
            return node

        fast = head.next
        cur = head

        while fast.next is not None:
            cur = cur.next

            fast = fast.next
            if fast.next is not None:
                fast = fast.next

        backend = cur.next
        cur.next = None # 注意中间断开
        
        return backend



    # 将两个有序的链表合并成一个
    def merge_list(self, list1: ListNode, list2: ListNode) -> ListNode:        
        tmp = ListNode(-1)
        cur = tmp
        while list1 is not None and list2 is not None:
            if list1.val < list2.val:
                cur.next = list1
                list1 = list1.next
            else:
                cur.next = list2
                list2 = list2.next

            cur = cur.next            
        
        if list1 is None:
            cur.next = list2
        elif list2 is None:
            cur.next = list1
        
        return tmp.next

