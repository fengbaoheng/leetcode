#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 根据前序遍历找到根
    # 根据根在中序遍历中划分左右子树
    # 递归生成子树
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        try:
            len_pre = len(preorder)
            len_in = len(inorder)

            if len_pre != len_in or len_pre == 0:
                return None

            # 找到根节点
            root_val = preorder[0]
            root = TreeNode(root_val)

            # 划分左右子树的遍历结果
            index = inorder.index(root_val)
            if index == -1:
                return None

            pre_left = preorder[1:1+index]
            pre_right = preorder[1+index:]

            in_left = inorder[:index]
            in_right = inorder[1+index:]

            # 生成左右子树
            root.left = self.buildTree(pre_left, in_left)
            root.right = self.buildTree(pre_right, in_right)

            return root

        except:
            return None
