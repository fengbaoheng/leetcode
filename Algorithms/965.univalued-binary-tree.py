#
# @lc app=leetcode.cn id=965 lang=python3
#
# [965] 单值二叉树
#
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isUnivalTree(self, root: TreeNode) -> bool:
        return self.is_unival(root, root.val)
    
    def is_unival(self, root:TreeNode, val:int)->bool:
        if root is None:
            return True
        
        else: 
            return root.val == val and self.is_unival(root.left, val) and self.is_unival(root.right, val)
        

