#
# @lc app=leetcode.cn id=109 lang=python3
#
# [109] 有序链表转换二叉搜索树
#
# Definition for singly-linked list.


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 快慢指针找到链表中点
    # 链表以终点拆分，左链表构造子树作为左子树，右链表构造子树作为右子树
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        try:
            # 空链表
            if head is None:
                return None
            # 单元素链表
            if head.next is None:
                return TreeNode(head.val)

            # 超过1个元素的链表进行拆分
            fast = head.next
            low = head
            before_low = head

            while fast is not None:
                before_low = low
                low = low.next

                fast = fast.next
                if fast is None:
                    break

                fast = fast.next

            # 链表尾指针置空
            before_low.next = None
            right_head = low.next
            low.next = None

            root = TreeNode(low.val)
            root.left = self.sortedListToBST(head)
            root.right = self.sortedListToBST(right_head)

            return root

        except Exception as e:
            raise e
