#
# @lc app=leetcode.cn id=98 lang=python3
#
# [98] 验证二叉搜索树
#


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 也可以中序遍历该树，判断是否是递增的
    def isValidBST(self, root: TreeNode) -> bool:
        return self.in_valid_range(root, -9999999999, 9999999999)

    # 给每棵树一个边界进行判断
    # 进入子树时对边界进行收缩并递归调用
    def in_valid_range(self, root: TreeNode, min_val: int, max_val: int) -> bool:
        if root is None:
            return True

        if min_val < root.val < max_val:
            # 根节点符合要求，则收缩范围继续判断子树
            left_is_valid = self.in_valid_range(root.left, min_val, root.val)
            right_is_valid = self.in_valid_range(root.right, root.val, max_val)
            return left_is_valid and right_is_valid
        else:
            return False
