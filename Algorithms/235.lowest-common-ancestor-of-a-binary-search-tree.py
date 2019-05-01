#
# @lc app=leetcode.cn id=235 lang=python3
#
# [235] 二叉搜索树的最近公共祖先
#


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        try:
            if root is None:
                return None

            min_val, max_val = (
                p.val, q.val) if p.val <= q.val else (q.val, p.val)
            if root.val == min_val or root.val == max_val or min_val < root.val < max_val:
                return root
            elif max_val < root.val:
                # 两个值都小与根，则在左子树
                return self.lowestCommonAncestor(root.left, p, q)
            elif root.val < min_val:
                return self.lowestCommonAncestor(root.right, p, q)
            else:
                return None

        except:
            return None
