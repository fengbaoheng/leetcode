#
# @lc app=leetcode.cn id=1008 lang=python3
#
# [1008] 先序遍历构造二叉树
#
from typing import List

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # 递归构造二叉树, 在于如何找到1个根节点值,m个左子树节点值,n个右子树节点值
    # 对于先序遍历, 根节点值总为第1个
    # 在剩余的值中, 依据二叉搜索树的性质:小于根节点值为左子树的值, 大于根节点值为右子树值
    # 递归构造即可
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        try:
            if preorder is None:
                return None
            
            length = len(preorder)
            if length == 0:
                return None
            elif length == 1:
                TreeNode(preorder[0])
            
            root_val = preorder[0]
            root = TreeNode(root_val)

            # index为拆分点索引,perorder[index] > root_val
            index = 0
            for i in range(1, length):
                # 找到第一个大于root_val的值
                if preorder[i] > root_val:
                    index = i
                    break

            if index == 0:
                # 剩下的全为左子树
                root.left = self.bstFromPreorder(preorder[1:])
            else:
                root.left = self.bstFromPreorder(preorder[1:index])
                root.right = self.bstFromPreorder(preorder[index:])
            
            return root
        except Exception as e:
            raise e

        

