#
# @lc app=leetcode.cn id=19 lang=python3
#
# [19] 删除链表的倒数第N个节点
#
# https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
#
# algorithms
# Medium (33.22%)
# Total Accepted:    40.4K
# Total Submissions: 121.8K
# Testcase Example:  '[1,2,3,4,5]\n2'
#
# 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
#
# 示例：
#
# 给定一个链表: 1->2->3->4->5, 和 n = 2.
#
# 当删除了倒数第二个节点后，链表变为 1->2->3->5.
#
#
# 说明：
#
# 给定的 n 保证是有效的。
#
# 进阶：
#
# 你能尝试使用一趟扫描实现吗？
#
#
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # 前后双指针
    # 两指针相差N, 即当前指针在i时,前沿指针在i+N
    # 当前沿指针到达末尾时, 删除当前指针所在的节点即可
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if head is None:
            return None
        if n <= 0:
            return head

        front: ListNode = head
        rear: ListNode = head

        # 前沿指针前进N
        for i in range(n):
            # N超过了链表长度
            if front is None:
                return None

            front = front.next

        
        # 删除的是头结点
        if front is None:
            return head.next


        # 依次移动,直到前沿指针到达最后一个数
        while front.next:
            rear = rear.next
            front = front.next

        # 删除节点
        rear.next = rear.next.next

        return head

