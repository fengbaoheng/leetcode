#
# @lc app=leetcode.cn id=143 lang=python3
#
# [143] 重排链表
#
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # 快慢指针分两段
    # 后段链表反转
    # 合并前后两段链表即可
    def reorderList(self, head: ListNode) -> None:
        if head is None or head.next is None:
            return
        
        backend = self.split(head)
        reversed_head = self.reverse(backend)
        self.merge(head, reversed_head)
    
    # 快慢指针 拆分两段链表
    def split(self, head:ListNode)->ListNode:
        if head is None or head.next is None:
            return None
        
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next        
        
        backend = slow.next
        slow.next = None
        return backend


    # 反转链表
    def reverse(self, head:ListNode)->ListNode:
        if head is None or head.next is None:
            return head

        reversed_head = None

        while head:
            # 取出一个节点
            node = head
            head = head.next
            
            # 转换节点指针
            node.next = reversed_head
            reversed_head = node
        
        return reversed_head


    # 合并链表
    def merge(self, head1:ListNode, head2:ListNode):
        cur = head1
        head1 = head1.next

        while head1 and head2:
            cur.next = head2
            cur = cur.next
            head2 = head2.next   

            cur.next = head1
            cur = cur.next
            head1 = head1.next

        if head1 is None:
            cur.next = head2
        elif head2 is None:
            cur.next = head1