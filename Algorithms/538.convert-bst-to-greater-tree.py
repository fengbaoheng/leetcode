#
# @lc app=leetcode.cn id=538 lang=python3
#
# [538] 把二叉搜索树转换为累加树
#
# https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
#
# algorithms
# Easy (51.50%)
# Total Accepted:    3.2K
# Total Submissions: 6.2K
# Testcase Example:  '[5,2,13]'
#
# 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
# Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
#
# 例如：
#
#
# 输入: 二叉搜索树:
# ⁠             5
# ⁠           /   \
# ⁠          2     13
#
# 输出: 转换为累加树:
# ⁠            18
# ⁠           /   \
# ⁠         20     13
#
#
#
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def convertBST(self, root: TreeNode) -> TreeNode:
        # 递归,针对二叉搜索树的性质
        # 右子树->根->左子树的顺序

        self.convert_with_more(root, 0)
        return root


    # 传入比根大的数字和, 返回转换为累加树后的数字和
    def convert_with_more(self, root:TreeNode, more:int = 0)->int:
        if root is None:
            return more
        
        root.val += self.convert_with_more(root.right, more)

        return self.convert_with_more(root.left, root.val)

