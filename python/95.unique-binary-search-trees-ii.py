#
# @lc app=leetcode.cn id=95 lang=python3
#
# [95] 不同的二叉搜索树 II
#
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 迭代生成树
    # 根节点每次从1-n取一个数, 左右子树依据根节点值进行划分
    def generateTrees(self, n: int) -> List[TreeNode]:
        try:
            if n < 1:
                return []

            nums = [i for i in range(1, n + 1)]
            return self.create_trees(nums)

        except Exception as e:
            raise e

    def create_trees(self, nums: List[int]) -> List[TreeNode]:
        try:
            length = len(nums)
            if length == 0:
                return [None]
            elif length == 1:
                return [TreeNode(nums[0])]

            trees = []
            for i in range(length):
                for left in self.create_trees(nums[:i]):
                    for right in self.create_trees(nums[i + 1 :]):
                        root = TreeNode(nums[i])
                        root.left = left
                        root.right = right
                        trees.append(root)

            return trees
        except Exception as e:
            raise e
