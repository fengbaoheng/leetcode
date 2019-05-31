#
# @lc app=leetcode.cn id=669 lang=python3
#
# [669] 修剪二叉搜索树
#


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 递归调用
    # 分情况讨论根节点值与区间[L,R]的关系
    def trimBST(self, root: TreeNode, L: int, R: int) -> TreeNode:
        try:
            if root is None:
                return None

            val = root.val

            # 只考虑右子树 
            if val < L:
                return self.trimBST(root.right, L, R)
            # 根节点和右子树
            elif val == L:
                root.left = None
                root.right = self.trimBST(root.right, L, R)
                return root
            # 只左子树
            elif val > R:
                return self.trimBST(root.left, L, R)
            # 根节点和左子树
            elif val == R:
                root.right = None
                root.left = self.trimBST(root.left, L, R)
                return root
            else:
                root.right = self.trimBST(root.right, L, R)
                root.left = self.trimBST(root.left, L, R)
                return root

        except Exception as e:
            raise e

