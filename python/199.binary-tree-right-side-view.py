#
# @lc app=leetcode.cn id=199 lang=python3
#
# [199] 二叉树的右视图
#
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        
        view = []
        cur_layer = []
        next_layer = [root]
        
        while next_layer:
            cur_layer = next_layer
            view.append(cur_layer[-1].val)

            next_layer = []
            for node in cur_layer:
                if node.left:
                    next_layer.append(node.left)
                if node.right:
                    next_layer.append(node.right)
        
        return view

        
        

