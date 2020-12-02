#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
#
from typing import List

class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        
        result = []
        stack = [root]

        while stack:
            node = stack.pop()

            result.append(node.val)

            for i in range(len(node.children)-1, -1, -1):
                stack.append(node.children[i])
        return result
        

