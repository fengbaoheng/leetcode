#
# @lc app=leetcode.cn id=106 lang=python3
#
# [106] 从中序与后序遍历序列构造二叉树
#

from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 后序遍历结果的最后一位为该树的根
    # 依据中序遍历划分左右子树，并递归生成
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        try:
            len_in = len(inorder)
            len_post = len(postorder)

            if len_in == 0 or len_in != len_post:
                return None

            # 得到根节点值
            root_val = postorder[-1]
            root = TreeNode(root_val)

            # 划分左右子树
            index = inorder.index(root_val)
            if index == -1:
                return None

            left_in = inorder[:index]
            right_in = inorder[index+1:]

            left_post = postorder[:len(left_in)]
            right_post = postorder[len(left_in):-1]

            # 递归生成子树
            root.left = self.buildTree(left_in, left_post)
            root.right = self.buildTree(right_in, right_post)

            return root

        except:
            return None
