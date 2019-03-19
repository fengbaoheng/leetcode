#
# @lc app=leetcode.cn id=111 lang=python3
#
# [111] 二叉树的最小深度
#
# https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
#
# algorithms
# Easy (37.19%)
# Total Accepted:    12.7K
# Total Submissions: 33.9K
# Testcase Example:  '[3,9,20,null,null,15,7]'
#
# 给定一个二叉树，找出其最小深度。
#
# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
#
# 说明: 叶子节点是指没有子节点的节点。
#
# 示例:
#
# 给定二叉树 [3,9,20,null,null,15,7],
#
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
#
# 返回它的最小深度  2.
#
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0

        # 递归 最近的叶子节点
        left_d = self.minDepth(root.left)
        right_d = self.minDepth(root.right)

        # 叶子节点
        if left_d == 0 and right_d == 0:
            return 1

        elif left_d == 0 and right_d != 0:
            return 1 + right_d
        elif left_d != 0 and right_d == 0:
            return 1 + left_d
        else:
            return 1 + min(left_d, right_d)

