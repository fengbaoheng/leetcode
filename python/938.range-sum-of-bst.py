#
# @lc app=leetcode.cn id=938 lang=python3
#
# [938] 二叉搜索树的范围和
#


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 不断递归查找即可
    def rangeSumBST(self, root: TreeNode, L: int, R: int) -> int:
        if root is None:
            return 0

        # 根节点值val有三种情况:
        # [L, root, R] val在搜索区间内, 左右子树分别递归
        # [root, L, R] val在搜索区间左边, 只递归右子树
        # [L, R, root] val在搜索区间右边, 只递归左子树

        val = root.val
        sum_val = 0

        # 是否在搜索区间边界上
        if val == L:
            sum_val = val + self.rangeSumBST(root.right, L + 1, R)
        elif val == R:
            sum_val = val + self.rangeSumBST(root.left, L, R - 1)
        elif L < val < R:
            sum_val = val + self.rangeSumBST(root.left, L, val - 1) + self.rangeSumBST(root.right, val + 1, R)
        elif val < L:
            sum_val = self.rangeSumBST(root.right, L, R)
        elif val > R:
            sum_val = self.rangeSumBST(root.left, L, R)

        return sum_val

