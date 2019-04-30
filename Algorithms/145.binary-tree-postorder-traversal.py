#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        stack = [[root, False]]
        result = []

        while len(stack) > 0:
            visited = stack[-1][1]

            if visited == True:
                # 如果已经访问该根节点，则直接弹出并记录
                node = stack.pop()[0]
                result.append(node.val)
            else:
                # 未访问过该根节点，则不弹出，仅修改访问标记
                # 并入栈右节点和左节点
                stack[-1][1] = True
                node = stack[-1][0]

                if node.right is not None:
                    stack.append([node.right, False])
                if node.left is not None:
                    stack.append([node.left, False])

        return result
