#
# @lc app=leetcode.cn id=404 lang=python3
#
# [404] 左叶子之和


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 不断递归，栈中记录节点
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if root is None:
            return 0

        stack = [(root, False)]
        left_leaf = []

        while len(stack) > 0:
            node, is_left = stack.pop()

            left, right = node.left, node.right

            if left is None and right is None and is_left:
                left_leaf.append(node)
            else:
                if left is not None:
                    stack.append((left, True))
                if right is not None:
                    stack.append((right, False))

        return sum(map(lambda x: x.val, left_leaf))
