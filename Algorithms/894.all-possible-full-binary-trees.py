#
# @lc app=leetcode.cn id=894 lang=python3
#
# [894] 所有可能的满二叉树
#
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def __init__(self):
        self.cache = {}

        self.cache[1] = [TreeNode(0)]

    # N只有为奇数时才可构造
    # 构造完1个根节点后,对剩下的N-1个节点,按奇数拆分为多种情况
    # 组合各种情况即可
    def allPossibleFBT(self, N: int) -> List[TreeNode]:
        if N <= 0 or N % 2 == 0:
            return []
        
        if N in self.cache:
            return self.cache[N]

        results = []
        for l in range(1, N, 2):
            r = N-1-l

            for left in self.allPossibleFBT(l):
                for right in self.allPossibleFBT(r):
                    root = TreeNode(0)
                    root.left = left
                    root.right = right
                    results.append(root)
                    
        self.cache[N] = results
        return results
