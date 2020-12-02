#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 使用栈迭代
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []

        stack = [root]
        result = []

        while len(stack) > 0:
            node = stack.pop()

            result.append(node.val)

            # 入栈先右后左， 出栈是先左后右
            if node.right is not None:
                stack.append(node.right)

            if node.left is not None:
                stack.append(node.left)

        return result
