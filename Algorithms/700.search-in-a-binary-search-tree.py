#
# @lc app=leetcode.cn id=700 lang=python3
#
# [700] Search in a Binary Search Tree
#
# https://leetcode-cn.com/problems/search-in-a-binary-search-tree/description/
#
# algorithms
# Easy (65.31%)
# Total Accepted:    5.3K
# Total Submissions: 8.1K
# Testcase Example:  '[4,2,7,1,3]\n2'
#
# 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
#
# 例如，
#
#
# 给定二叉搜索树:
#
# ⁠       4
# ⁠      / \
# ⁠     2   7
# ⁠    / \
# ⁠   1   3
#
# 和值: 2
#
#
# 你应该返回如下子树:
#
#
# ⁠     2
# ⁠    / \
# ⁠   1   3
#
#
# 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
#
#
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 按照二叉搜索树的性质逐层比较即可
    def searchBST(self, root: TreeNode, val: int) -> TreeNode:
        if root is None:
            return None

        if root.val == val:
            return root
        elif val < root.val:
            return self.searchBST(root.left, val)
        else:
            return self.searchBST(root.right, val)

