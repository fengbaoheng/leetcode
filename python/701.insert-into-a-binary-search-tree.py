#
# @lc app=leetcode.cn id=701 lang=python3
#
# [701] 二叉搜索树中的插入操作
#
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 递归思路
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        # 空树则构造单根节点返回
        if root is None:
            return TreeNode(val)

        # 比较val与根节点值的大小关系
        if val > root.val:
            root.right = self.insertIntoBST(root.right, val)
        else:
            # 只能大于或小于, 题目输入保证不重复
            root.left = self.insertIntoBST(root.left, val)

        return root

