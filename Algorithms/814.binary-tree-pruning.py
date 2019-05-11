#
# @lc app=leetcode.cn id=814 lang=python3
#
# [814] 二叉树剪枝
#
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 递归
    def pruneTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None

        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)


        # 根节点值为0,且没有子树则整颗树被剪掉
        if root.val == 0 and root.left is None and root.right is None:
            return None

        return root
        

