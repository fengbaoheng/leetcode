#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#
from typing import List

# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 左 + 根 + 右
    # 递归算法
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # 边界情况
        if root is None:
            return []

        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)

    # 使用栈进行迭代
    def inorderTraversalByStack(self, root: TreeNode) -> List[int]:
        if root is None:
            return []

        # 添加标记，记录是否访问过
        stack = [(root, False)]
        result = []

        while len(stack) != 0:
            node, visited = stack.pop()

            if visited == True:
                result.append(node.val)
            else:
                # 入栈 右中左， 出栈 左中右
                right, left = node.right, node.left

                if right is not None:
                    stack.append((right, False))

                stack.append((node, True))

                if left is not None:
                    stack.append((left, False))

        return result
