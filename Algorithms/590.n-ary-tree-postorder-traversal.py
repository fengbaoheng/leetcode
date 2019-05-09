#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#
from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []

        result: List[int] = []
        stack: List[Node] = []
        
        stack.append(root)
        while stack:
            node = stack.pop()
            result.append(node.val)
            
            for child in node.children:
                if child is not None:
                    stack.append(child)
        
        result.reverse()


        return result
