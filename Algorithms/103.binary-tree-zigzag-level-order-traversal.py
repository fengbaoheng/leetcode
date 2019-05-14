#
# @lc app=leetcode.cn id=103 lang=python3
#
# [103] 二叉树的锯齿形层次遍历
#
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root is None:
            return []
        
        cur_layer = []
        next_layer = [root]
        layer = 0

        result = []


        while next_layer:
            layer += 1
            cur_layer = next_layer
            next_layer = []

            layer_val = []
            for node in cur_layer:
                layer_val.append(node.val)
                if node.left is not None:
                    next_layer.append(node.left)
                if node.right is not None:
                    next_layer.append(node.right)

            if layer % 2 == 0:
                layer_val.reverse()
                
            result.append(layer_val)

        return result



