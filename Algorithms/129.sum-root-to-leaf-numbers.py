#
# @lc app=leetcode.cn id=129 lang=python3
#
# [129] 求根到叶子节点数字之和
#
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        try:
            if root is None:
                return 0

            return sum(self.get_numbers(root, 0))
        except Exception as e:
            raise e

    # 找到所有根到叶子节点的数字
    # num:根到当前节点前组合成的数字
    def get_numbers(self, root: TreeNode, num: int) -> List[int]:
        try:
            if root is None:
                return []

            cur_val = num * 10 + root.val

            if root.left is None and root.right is None:
                return [cur_val]

            numbers = []
            numbers.extend(self.get_numbers(root.left, cur_val))
            numbers.extend(self.get_numbers(root.right, cur_val))

            return numbers

        except Exception as e:
            raise e

