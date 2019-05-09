#
# @lc app=leetcode.cn id=559 lang=python3
#
# [559] N叉树的最大深度
#


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution:
    # 递归子树求深度
    def maxDepth(self, root: 'Node') -> int:
        if root is None:
            return 0
        
        # 没有子树，只有根节点1层
        if root.children is None or len(root.children) == 0:
            return 1
        
        # 对每颗子树递归调用求最大深度
        return 1 + max(map(self.maxDepth, root.children))

        

