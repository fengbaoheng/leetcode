#
# @lc app=leetcode.cn id=654 lang=python3
#
# [654] 最大二叉树
#
# Definition for a binary tree node.


from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        try:
            length = len(nums)
            if length == 0:
                return None
            elif length == 1:
                return TreeNode(nums[0])

            max_index = self.find_max_index(nums)
            max_num = nums[max_index]
            
            root = TreeNode(max_num)
            root.left = self.constructMaximumBinaryTree(nums[:max_index])
            root.right = self.constructMaximumBinaryTree(nums[max_index+1:])

            return root
        except:
            return None

    # 求最大数的索引
    def find_max_index(self, nums: List[int]) -> int:
        try:
            length = len(nums)
            if length == 0:
                return -1
            elif length == 1:
                return 0

            max_index = 0
            max_num = nums[0]
            for i in range(length):
                if nums[i] > max_num:
                    max_num = nums[i]
                    max_index = i

            return max_index
        except:
            return -1
