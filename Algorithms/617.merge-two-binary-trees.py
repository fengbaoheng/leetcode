#
# @lc app=leetcode.cn id=617 lang=python3
#
# [617] 合并二叉树


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 递归合并子树
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        try:
            if t1 and t2:
                t1.val += t2.val
                t1.left = self.mergeTrees(t1.left, t2.left)
                t1.right = self.mergeTrees(t1.right, t2.right)
                return t1
            else:
                # 如果有任一树为空，则返回不为空的树
                # 两树均为空则返回任一个空树均可
                return t1 if t2 is None else t2
        except Exception as e:
            raise e
